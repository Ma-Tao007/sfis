package com.entity;

/**
 * 教师封装类
 * @author OldFish
 *
 */

public class Teacher
{
	private String tchNO;// 教师编号
	private String tchName;// 教师姓名
	private String password;// 密码
	private String gender;// 性别
	private String tel;// 联系方式
	private String tchEmail;// 教师邮箱
	private Student student;
	private String remark;// 标记
	private String role;// 角色
	
	public String getTchNO()
	{
		return tchNO;
	}
	public void setTchNO(String tchNO)
	{
		this.tchNO = tchNO;
	}
	public String getTchName()
	{
		return tchName;
	}
	public void setTchName(String tchName)
	{
		this.tchName = tchName;
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
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	public String getTchEmail()
	{
		return tchEmail;
	}
	public void setTchEmail(String tchEmail)
	{
		this.tchEmail = tchEmail;
	}
	public Student getStudent()
	{
		return student;
	}
	public void setStudent(Student student)
	{
		this.student = student;
	}
	public String getRole()
	{
		return role;
	}
	public void setRole(String role)
	{
		this.role = role;
	}
	public String getRemark()
	{
		return remark;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
}
