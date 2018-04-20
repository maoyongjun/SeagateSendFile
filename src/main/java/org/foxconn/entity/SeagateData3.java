package org.foxconn.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SeagateData3  extends BaseStringArray{
	private Integer num;
	private String sysserialno;
	private String actioncode;
	private String description;
	private Date createdate;
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getSysserialno() {
		return sysserialno;
	}
	public void setSysserialno(String sysserialno) {
		this.sysserialno = sysserialno;
	}
	public String getActioncode() {
		return actioncode;
	}
	public void setActioncode(String actioncode) {
		this.actioncode = actioncode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String[] toStringArray() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String createdate = sdf.format(this.createdate);
		return new String[]{ String.valueOf(num),sysserialno,actioncode,description,createdate};
	}
	public String[] getHeader() {
		return new String[]{"num","sysserialno","actioncode","description","createdate"};
	}
	
}
