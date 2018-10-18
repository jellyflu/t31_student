package com.tingcream.t31_student.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;


public class DbConfig {
 
   private static  BasicDataSource basicDataSource;

   static {
	   // DbUtils.loadDriver(JDBC_DRIVER);
	   
	    InputStream in =null;
	    try {
	    	in= DbConfig.class.getClassLoader().getResourceAsStream("jdbc.properties");
	    	 Properties prop =new Properties();
	 	     prop.load(in);
	 	     String  username =prop.getProperty("jdbc.username");
	 	     String  password =prop.getProperty("jdbc.password");
	 	     String  url =prop.getProperty("jdbc.url");
	 	     String  driverClassName =prop.getProperty("jdbc.driverClassName");
	 	     
	 	      basicDataSource = new BasicDataSource();
	 	      basicDataSource.setDriverClassName(driverClassName);
	 	      basicDataSource.setUsername(username);
	 	      basicDataSource.setPassword(password);
	 	      basicDataSource.setUrl(url);
		} catch (Exception e) {
		   e.printStackTrace();
		}finally {
			if(in!=null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	    
   }

   public static DataSource getDataSource() {
      return basicDataSource;
   }
	 

}
