package com.tingcream.t31_student.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tingcream.t31_student.db.DBUtil;
import com.tingcream.t31_student.util.StringUtil;

/**
 * 学生dao层
 * @author jelly
 *
 */
public class StudentDao {
	
	   
	
	/**
	 * 查询学生对象 
	 * @param studentNo  学号
	 * @param name  姓名
	 * @return
	 */
	public  List<Student> findStudent(String studentNo,String name ){
	 
         StringBuilder sql   =new StringBuilder () ;
		 sql.append("select * from  t_student where 1=1 ");
		 if(StringUtil.isNotBlank(studentNo) ) {
			 sql.append("and studentNo=?");
		 }
		 if(StringUtil.isNotBlank(name)) {
			 sql.append("and name like concat('%',?,'%')");
		 }
		 sql.append("order by createtime asc");
		 
		 Connection conn=null;
         PreparedStatement ps=null;
         try {
        	 conn= DBUtil.getConn();
        	 ps=conn.prepareStatement(sql.toString());
        	 if(StringUtil.isNotBlank(studentNo) && StringUtil.isNotBlank(name)) {
        		 ps.setString(1, studentNo);
        		 ps.setString(2, name);
        	 }else if(StringUtil.isNotBlank(studentNo)) {
        		 ps.setString(1, studentNo);
        	 }else if(StringUtil.isNotBlank(name)) {
        		 ps.setString(1, name);
        	 }
        	 ResultSet rs =  ps.executeQuery();
             List<Student>  list=new ArrayList<Student>();
             while(rs.next()){
	               Student student =new Student();
	               student.setId(rs.getInt("id"));
	               student.setName(rs.getString("name"));
	               student.setBirthday(rs.getString("birthday"));
	               student.setContactTel(rs.getString("contactTel"));
	               student.setCreatetime(rs.getString("createtime"));
	               student.setFamilyAddr(rs.getString("familyAddr"));
	               student.setSex(rs.getInt("sex"));
	               student.setStudentNo(rs.getString("studentNo"));
	              
	               list.add(student);
	        }
	        return list ;
		}  catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			try {
              if(ps!=null){
                  ps.close();
              }
                DBUtil.closeConn(conn);
	          } catch (SQLException e) {
	              e.printStackTrace();
	          }
	      }
	}
    
	
	
	/**
	 *   查询所有学生
	 *  @return
	 */
	public  List<Student> findAllStudent(){
		 Connection conn=null;
		 PreparedStatement ps=null;
		 try {
			 conn= DBUtil.getConn();
			 String sql ="select  * from t_student order by createtime asc";
			 ps=conn.prepareStatement(sql);
			 
			 ResultSet rs =  ps.executeQuery();
             List<Student>  list=new ArrayList<Student>();
             
             while(rs.next()){
	               Student student =new Student();
	               student.setId(rs.getInt("id"));
	               student.setName(rs.getString("name"));
	               student.setBirthday(rs.getString("birthday"));
	               student.setContactTel(rs.getString("contactTel"));
	               student.setCreatetime(rs.getString("createtime"));
	               student.setFamilyAddr(rs.getString("familyAddr"));
	               student.setSex(rs.getInt("sex"));
	               student.setStudentNo(rs.getString("studentNo"));
	              
	               list.add(student);
	        }
	        return list ;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			try {
              if(ps!=null){
                  ps.close();
              }
              DBUtil.closeConn(conn);
	          } catch (SQLException e) {
	              e.printStackTrace();
	          }
	      }
 
	}


	
	/**
	 * 根据id查询 
	 * @param id 主键id
	 * @return
	 */
	public Student findById(Integer id) {
		Connection conn=null;
        PreparedStatement ps=null;
        try {
       	 conn= DBUtil.getConn();
       	 ps=conn.prepareStatement("select * from t_student where id=?");
       	 ps.setInt(1, id);
       	  ResultSet rs =  ps.executeQuery();
            if(rs.next()){
	               Student student =new Student();
	               student.setId(rs.getInt("id"));
	               student.setName(rs.getString("name"));
	               student.setBirthday(rs.getString("birthday"));
	               student.setContactTel(rs.getString("contactTel"));
	               student.setCreatetime(rs.getString("createtime"));
	               student.setFamilyAddr(rs.getString("familyAddr"));
	               student.setSex(rs.getInt("sex"));
	               student.setStudentNo(rs.getString("studentNo"));
	               return student;
	        }else {
	        	return null;
	        }
		}  catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			try {
             if(ps!=null){
                 ps.close();
             }
               DBUtil.closeConn(conn);
	          } catch (SQLException e) {
	              e.printStackTrace();
	          }
	      }
	}

    /**
     * 根据id删除
     * @param id
     * @return
     */
	public int deleteById(Integer id) {
		 Connection conn=null;
		 PreparedStatement ps=null;
		 try {
			 conn= DBUtil.getConn();
			 String sql="DELETE FROM `t_student` WHERE id=?";
			 ps=conn.prepareStatement(sql);
			 ps.setInt(1, id);
			 
			return ps.executeUpdate();
			 
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			try {
              if(ps!=null){
                  ps.close();
              }
              DBUtil.closeConn(conn);
	          } catch (SQLException e) {
	              e.printStackTrace();
	          }
	      }
	}
	
	/**
	 * 保存   返回int 自增主键
	 * @param student  学生对象
	 * @return
	 */
	public int save(Student student) {
		Connection conn=null;
        PreparedStatement ps=null;
        try {
       	 conn= DBUtil.getConn();
       	 String sql ="INSERT INTO `t_student`(studentNo,`name`,sex,birthday,familyAddr,contactTel,createtime)" + 
       	 		   "VALUES(?,?,?,?,?,?,NOW())";
         ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
         ps.setString(1, student.getStudentNo());
         ps.setString(2, student.getName());
         ps.setInt(3, student.getSex());
         ps.setString(4, student.getBirthday());
         ps.setString(5, student.getFamilyAddr());
         ps.setString(6, student.getContactTel());
         
          
          ps.executeUpdate();
          ResultSet rs = ps.getGeneratedKeys();
          if(rs.next()) {
        	  return rs.getInt(1);//返回自增主键
        	  
          }
       	  return -1 ;
		}  catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			try {
              if(ps!=null){
                 ps.close();
              }
               DBUtil.closeConn(conn);
	          } catch (SQLException e) {
	              e.printStackTrace();
	          }
	      }
	}


   /**
    * 更新 
    * @param student
    * @return
    */
	public int update(Student student) {
		Connection conn=null;
        PreparedStatement ps=null;
        try {
       	 conn= DBUtil.getConn();
       	 
       	 String sql="UPDATE   `t_student` a  SET  a.`studentNo`=? ,a.name=? ,a.sex=?," + 
       	 		"a.`birthday`=? ,a.`familyAddr`=? ,a.`contactTel`=? where a.id=?";
         ps = conn.prepareStatement(sql);
         ps.setString(1, student.getStudentNo());
         ps.setString(2, student.getName());
         ps.setInt(3, student.getSex());
         ps.setString(4, student.getBirthday());
         ps.setString(5, student.getFamilyAddr());
         ps.setString(6, student.getContactTel());
         ps.setInt(7, student.getId());
         
         return   ps.executeUpdate();//返回受影响的行数
       	  
		}  catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			try {
              if(ps!=null){
                 ps.close();
              }
               DBUtil.closeConn(conn);
	          } catch (SQLException e) {
	              e.printStackTrace();
	          }
	      }
		
	}
}
