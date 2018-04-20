package org.foxconn.entity;


public class SeagateData4  extends BaseStringArray{
	private String SSN;
	private String STATION;
	private String eventfail;
	private String DATA;
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String getSTATION() {
		return STATION;
	}
	public void setSTATION(String sTATION) {
		STATION = sTATION;
	}
	public String getEventfail() {
		return eventfail;
	}
	public void setEventfail(String eventfail) {
		this.eventfail = eventfail;
	}
	public String getDATA() {
		return DATA;
	}
	public void setDATA(String dATA) {
		DATA = dATA;
	}
	
	public String[] toStringArray() {
		return new String[]{ SSN,STATION,eventfail,DATA};
	}
	public String[] getHeader() {
		return new String[]{"SSN","STATION","eventfail","DATA"};
	}
	
}
