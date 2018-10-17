package com.tingcream.t31_student.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static String dbUrl="jdbc:mysql://localhost:3306/t31_student?useUnicode=true&characterEncoding=UTF8&useSSL=false";
    private static String dbUsername="root";//用户名
    private static String dbPassword="123456";//密码
    private static String dbDriverClassName="com.mysql.jdbc.Driver";//驱动名称
     
     
    //获取数据库连接
    public static Connection  getConn() throws SQLException, ClassNotFoundException {
        Class.forName(dbDriverClassName);
        Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        return conn ;
    }
    //关闭数据库连接
    public static void closeConn(Connection conn) throws SQLException{
        if(conn!=null){
            conn.close();
        }
    }
    
//    public static void main(String[] args) throws Exception{
//    	testConn();
//	}
//    
//    /**
//     * 测试连接 ok
//     * @throws Exception
//     */
//   private  static void  testConn()throws Exception{
//        Connection conn=null;
//        try {
//          conn=getConn();
//          System.out.println("获取数据库连接成功");
//          System.out.println(conn);
//      } catch (Exception e) {
//          e.printStackTrace();
//          System.out.println("获取数据库连接失败");
//      }finally{
//          closeConn(conn);
//      }
//    }

}
