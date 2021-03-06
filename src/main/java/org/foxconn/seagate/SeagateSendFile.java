package org.foxconn.seagate;

import org.apache.log4j.Logger;
import org.foxconn.database.DataSourceHolder;
import org.foxconn.service.SeagateDataService;
import org.foxconn.util.ContextUtil;
import org.springframework.context.ApplicationContext;

public class SeagateSendFile {
	private static ApplicationContext ac;
		
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(SeagateSendFile.class);
		ac =  ContextUtil.getContext();
		SeagateDataService service =ac.getBean("seagateDataServiceImpl", SeagateDataService.class);
		try {
			DataSourceHolder.setDataSource(DataSourceHolder.seagate);
			service.sendFile();
			DataSourceHolder.setDataSource(DataSourceHolder.dothill);
			service.sendFile();
		} catch (Exception e) {
			logger.error("Error:"+e.getMessage());
		}
	}
}
