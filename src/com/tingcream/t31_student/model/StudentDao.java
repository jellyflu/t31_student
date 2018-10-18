package com.tingcream.t31_student.model;

import java.sql.SQLException;
import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.tingcream.t31_student.db.DbConfig;
import com.tingcream.t31_student.util.StringUtil;

/**
 * 学生dao层
 * @author jelly
 *
 */
public class StudentDao {
	
	private  QueryRunner queryRunner=new QueryRunner(DbConfig.getDataSource());
	
	
	/**
	 * 查询所有学生 
	 * @return
	 */
	public  List<Student> findAllStudent()  {
		
		   try {
			String sql ="select  * from t_student order by id asc";
			   List<Student> list = queryRunner.query(sql,new BeanListHandler<Student>(Student.class));
			   return list ;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	   
	/**
	 * 根据学号或姓名查询 学生列表
	 * @param studentNo
	 * @param name
	 * @return
	 */
	public  List<Student> findStudent(String studentNo,String name)      {
		
		
		 try {
			StringBuilder sql   =new StringBuilder () ;
			 sql.append("select * from  t_student where 1=1 ");
			 if(StringUtil.isNotBlank(studentNo) ) {
				 sql.append("and studentNo=?");
			 }
			 if(StringUtil.isNotBlank(name)) {
				 sql.append("and name like concat('%',?,'%')");
			 }
			 sql.append("order by id asc"); 
			 if(StringUtil.isNotBlank(studentNo) && StringUtil.isNotBlank(name)) {
				return  queryRunner.query(sql.toString(), new BeanListHandler<Student>(Student.class),  studentNo,name);
			 }else if(StringUtil.isNotBlank(studentNo)) {
				 return  queryRunner.query(sql.toString(), new BeanListHandler<Student>(Student.class),  studentNo);
			 }else if(StringUtil.isNotBlank(name)) {
				 
				 return  queryRunner.query(sql.toString(), new BeanListHandler<Student>(Student.class),  name);
			 }else {
				 
				 return  queryRunner.query(sql.toString(), new BeanListHandler<Student>(Student.class));
			 }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * 根据id查询 
	 * @param id 主键id
	 * @return
	 */
	public Student findById(Integer id)   {
		   String sql ="select * from t_student where id=?";
		 try {
			return  queryRunner.query(sql, new BeanHandler<Student>(Student.class),  id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * 根据id删除  返回受影响的行数
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id)   {
		String sql="DELETE FROM `t_student` WHERE id=?";
		try {
			return queryRunner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 更新 学生
	 * @param student
	 * @return
	 * @throws SQLException
	 */
	public int update(Student student)  {
		 String sql="UPDATE   `t_student` a  SET  a.`studentNo`=? ,a.name=? ,a.sex=?," + 
   	 		"a.`birthday`=? ,a.`familyAddr`=? ,a.`contactTel`=? where a.id=?";
		try {
			return  queryRunner.update(sql,student.getStudentNo(),student.getName(),student.getSex(),
					 student.getBirthday(),student.getFamilyAddr(),student.getContactTel(),student.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		 
	}
	
	/**
	 * 插入数据 返回自增主键
	 * @param student
	 * @return
	 */
	public int save(Student student)  {
		 String sql ="INSERT INTO `t_student`(studentNo,`name`,sex,birthday,familyAddr,contactTel,createtime)" + 
 	 		   "VALUES(?,?,?,?,?,?,NOW())";
		 try {
			 Long id=  queryRunner.insert(sql, new ScalarHandler<Long>(), student.getStudentNo(),student.getName(),
					 student.getSex(),student.getBirthday(),student.getFamilyAddr(),student.getContactTel());
			 return  id.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
 
}
