package com.jwillim.entity;

import java.util.Date;

public class Message
{
	private String content;
	private Date sendTime;
	private String userName;
	
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public Date getSendTime()
	{
		return sendTime;
	}
	public void setSendTime(Date sendTime)
	{
		this.sendTime = sendTime;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}

}
