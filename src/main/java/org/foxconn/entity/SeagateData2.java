package org.foxconn.entity;

import java.text.SimpleDateFormat;

public class SeagateData2  extends BaseStringArray{
	private String ssn;
	private String skuno;
	private String csn;
	private String partno;
	private String miaoshu;
	private String subSSN;
	private String subCSN;
	private String subPARTNO;
	private String subMIAOSHU;
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSkuno() {
		return skuno;
	}
	public void setSkuno(String skuno) {
		this.skuno = skuno;
	}
	public String getCsn() {
		return csn;
	}
	public void setCsn(String csn) {
		this.csn = csn;
	}
	public String getPartno() {
		return partno;
	}
	public void setPartno(String partno) {
		this.partno = partno;
	}
	public String getMiaoshu() {
		return miaoshu;
	}
	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}
	public String getSubSSN() {
		return subSSN;
	}
	public void setSubSSN(String subSSN) {
		this.subSSN = subSSN;
	}
	public String getSubCSN() {
		return subCSN;
	}
	public void setSubCSN(String subCSN) {
		this.subCSN = subCSN;
	}
	public String getSubPARTNO() {
		return subPARTNO;
	}
	public void setSubPARTNO(String subPARTNO) {
		this.subPARTNO = subPARTNO;
	}
	public String getSubMIAOSHU() {
		return subMIAOSHU;
	}
	public void setSubMIAOSHU(String subMIAOSHU) {
		this.subMIAOSHU = subMIAOSHU;
	}
	
	public String[] toStringArray() {
		return new String[]{ ssn,skuno,csn,partno,miaoshu,subSSN,subCSN,subPARTNO,subMIAOSHU};
	}
	public String[] getHeader() {
		// TODO Auto-generated method stub
		return new String[]{  "ssn","skuno","csn","partno","miaoshu","subSSN","subCSN","subPARTNO","subMIAOSHU"};
	}
	
	
}
