package com.tingcream.t31_student.model;

import java.io.Serializable;
/**
 * 学生实体 
 * @author jelly
 *
 */
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
  
	private Integer  id;//学生表主键
	private String  studentNo;//学号
	private String  name;//姓名
	private Integer sex=1;// 性别  1男 2女
	private String  birthday;//生日  1992-02-04
	private String  familyAddr;//家庭地址
	private String  contactTel ;//联系电话
	private String createtime; //创建时间
	
	//pojo扩展属性
	public String getSexName() {
		return   this.sex==1?"男":"女";
		
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getFamilyAddr() {
		return familyAddr;
	}
	public void setFamilyAddr(String familyAddr) {
		this.familyAddr = familyAddr;
	}
	public String getContactTel() {
		return contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentNo=" + studentNo + ", name=" + name + ", sex=" + sex + ", birthday="
				+ birthday + ", familyAddr=" + familyAddr + ", contactTel=" + contactTel + ", createtime=" + createtime
				+ "]";
	}
	
	
}
