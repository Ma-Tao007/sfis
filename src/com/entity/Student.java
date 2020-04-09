package com.entity;

import java.util.Date;

/**
 * 学生封装类
 * @author OldFish
 *
 */

public class Student
{
	private String stuNO;// 学生学号
	private String stuName;// 学生姓名
	private String password;// 密码
	private String gender;// 性别
	private Date birthday;// 出生日期
	private String stuClass;// 班级
	private String department;// 学院
	private String stuEmail;// 学生邮箱
	private String remark;// 标记
	private String role;// 角色
	private Parent parent;
	
	public String getStuNO()
	{
		return stuNO;
	}
	public void setStuNO(String stuNO)
	{
		this.stuNO = stuNO;
	}
	public String getStuName()
	{
		return stuName;
	}
	public void setStuName(String stuName)
	{
		this.stuName = stuName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public Date getBirthday()
	{
		return birthday;
	}
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
	public String getStuClass()
	{
		return stuClass;
	}
	public void setStuClass(String stuClass)
	{
		this.stuClass = stuClass;
	}
	public String getDepartment()
	{
		return department;
	}
	public void setDepartment(String department)
	{
		this.department = department;
	}
	public String getStuEmail()
	{
		return stuEmail;
	}
	public void setStuEmail(String stuEmail)
	{
		this.stuEmail = stuEmail;
	}
	public String getRemark()
	{
		return remark;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRole()
	{
		return role;
	}
	public void setRole(String role)
	{
		this.role = role;
	}
	public Parent getParent()
	{
		return parent;
	}
	public void setParent(Parent parent)
	{
		this.parent = parent;
	}
}
