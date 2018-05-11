package org.foxconn.database;
/**
* @author:myz
* @version 1.0 
*/
public class DataSourceHolder {
	public static String seagate = "seagate";
    public static String dothill = "dothill";
    private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();
    public static void setDataSource(String customerType) {
        dataSources.set(customerType);
    }
    public static String getDataSource() {
        return (String) dataSources.get();
    }
    public static void clearDataSource() {
        dataSources.remove();
    }
 
}