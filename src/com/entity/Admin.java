package com.entity;

/**
 * 管理员封装类
 * @author OldFish
 *
 */

public class Admin
{
	private int id;// 管理员ID
	private String adminName;// 管理员姓名
	private String password;// 密码
	private String adminEmail;// 管理员邮箱
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getAdminName()
	{
		return adminName;
	}
	public void setAdminName(String adminName)
	{
		this.adminName = adminName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getAdminEmail()
	{
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail)
	{
		this.adminEmail = adminEmail;
	}
}
