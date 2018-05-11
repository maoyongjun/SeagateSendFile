package org.foxconn.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.aspectj.weaver.GeneratedReferenceTypeDelegate;
import org.foxconn.dao.SearchdataDao;
import org.foxconn.database.DataSourceHolder;
import org.foxconn.entity.SeagateData1;
import org.foxconn.entity.SeagateData2;
import org.foxconn.entity.SeagateData3;
import org.foxconn.entity.SeagateData4;
import org.foxconn.service.SeagateDataService;
import org.foxconn.util.ExcleExportUtil;
import org.foxconn.util.ToStringArrayUtil;
import org.foxconn.util.UploadFile;
import org.springframework.stereotype.Service;
@Service
public class SeagateDataServiceImpl implements SeagateDataService {
	Logger logger = Logger.getLogger(SeagateDataServiceImpl.class);
	private List<SeagateData1> data1;
	private List<SeagateData2> data2;
	private List<SeagateData3> data3;
	private List<SeagateData4> data4;
	private String basePath ="";//= "C:\\Users\\H7108464\\Desktop\\";
	private String fileName ;
	private String path;
	private long time;
	@Resource
	SearchdataDao searchdataDao;
	@Override
	public void sendFile() throws Exception {
		 time=new Date().getTime();
		 List<List<?>> list =null;
		 try {
			 list=searchdataDao.findData();
		 } catch (Exception e) {
			 throw e;
		 }
		 data1 = (List<SeagateData1>)list.get(0);
		 data2 = (List<SeagateData2>)list.get(1);
		 data3 = (List<SeagateData3>)list.get(2);
		 data4 = (List<SeagateData4>)list.get(3);
		 logger.info("getData from DB By SP"
		 		+",data1:"+data1.size()
		 		+",data2:"+data2.size()
		 		+",data3:"+data3.size()
		 		+",data4:"+data4.size());
		 writeExcle();
		 FileInputStream in = new FileInputStream(new File(fileName));
		 try {
			 list=searchdataDao.findData();
			 String result = UploadFile.uploadFile("10.67.70.95", 21,"tjlxme","CabgLXME201801", "/seagateData",fileName,in );
			 Date diffTime = new  Date(new Date().getTime()-time);
			 logger.info("take time:"+diffTime.getMinutes()+":"+diffTime.getSeconds());
			 logger.info("upload ftp result:"+result);
		 } catch (Exception e) {
			 throw e;
		 }
	}
	
	private void writeExcle(){
		logger.debug("begin write Excle");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		fileName =(DataSourceHolder.seagate.equals(DataSourceHolder.getDataSource())?"SG_":"DH_")+sdf.format( new Date())+".xlsx";
		List<ArrayList<String[]>> ls =new ArrayList<ArrayList<String[]>>();
		ls.add((ArrayList<String[]>) ToStringArrayUtil.toStringArray(data1));
		ls.add((ArrayList<String[]>) ToStringArrayUtil.toStringArray(data2));
		ls.add((ArrayList<String[]>) ToStringArrayUtil.toStringArray(data3));
		ls.add((ArrayList<String[]>) ToStringArrayUtil.toStringArray(data4));
		File file = new File(basePath+fileName);
		try {
			logger.debug("try to write Excle,sheet count:"+ls.size());
			ExcleExportUtil.write_Excel(file,(ArrayList)ls, new String[]{"data1","data2","data3","data4"}, "2");
			logger.info("write Excle success,path:"+(path = file.getAbsolutePath()));
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("IOException"+e.getMessage());
		}catch (Exception e) {
			logger.error("Exception"+e.getMessage());
		}
	}

}
