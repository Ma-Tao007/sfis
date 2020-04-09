package com.entity;

/**
 * 父母封装类
 * @author OldFish
 *
 */

public class Parent
{
	private String tel;// 父母手机号码
	private String parName;// 父母姓名
	private String password;// 密码
	private String relation;// 与学生的关系
	private String job;// 职业
	private String address;// 家庭住址
	private String parEmail;// 父母邮箱
	private Student student;
	private String role;// 角色
	
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	public String getParName()
	{
		return parName;
	}
	public void setParName(String parName)
	{
		this.parName = parName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getRelation()
	{
		return relation;
	}
	public void setRelation(String relation)
	{
		this.relation = relation;
	}
	public String getJob()
	{
		return job;
	}
	public void setJob(String job)
	{
		this.job = job;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getParEmail()
	{
		return parEmail;
	}
	public void setParEmail(String parEmail)
	{
		this.parEmail = parEmail;
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
}
