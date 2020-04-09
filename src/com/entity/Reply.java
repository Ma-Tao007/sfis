package com.entity;

import java.util.Date;

/**
 * 回复留言封装类
 * @author OldFish
 *
 */

public class Reply
{
	private int id;// 回复ID
	private String content;// 回复内容
	private Date replyTime;//  回复时间
	private String replyID;
	private Message message;
	private Student student;
	private Parent parent;
	private Teacher teacher;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public Date getReplyTime()
	{
		return replyTime;
	}
	public void setReplyTime(Date replyTime)
	{
		this.replyTime = replyTime;
	}
	public Message getMessage()
	{
		return message;
	}
	public void setMessage(Message message)
	{
		this.message = message;
	}
	public Student getStudent()
	{
		return student;
	}
	public void setStudent(Student student)
	{
		this.student = student;
	}
	public Parent getParent()
	{
		return parent;
	}
	public void setParent(Parent parent)
	{
		this.parent = parent;
	}
	public Teacher getTeacher()
	{
		return teacher;
	}
	public void setTeacher(Teacher teacher)
	{
		this.teacher = teacher;
	}
	public String getReplyID()
	{
		return replyID;
	}
	public void setReplyID(String replyID)
	{
		this.replyID = replyID;
	}
}
