package com.entity;

import java.util.Date;

/**
 * 留言封装类
 * @author OldFish
 *
 */

public class Message
{
	private int id;// 留言ID
	private String title;// 留言标题
	private String content;// 留言内容
	private Date sendTime;// 发送时间
	private String senderID;
	private String receiverID;
	private String remark;// 标记已读、未读
	private Student Student;
	private Teacher teacher;
	private Parent parent;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public Date getSendTime()
	{
		return sendTime;
	}
	public void setSendTime(Date sendTime)
	{
		this.sendTime = sendTime;
	}
	public String getSenderID()
	{
		return senderID;
	}
	public void setSenderID(String senderID)
	{
		this.senderID = senderID;
	}
	public String getReceiverID()
	{
		return receiverID;
	}
	public void setReceiverID(String receiverID)
	{
		this.receiverID = receiverID;
	}
	public Student getStudent()
	{
		return Student;
	}
	public void setStudent(Student student)
	{
		Student = student;
	}
	public Teacher getTeacher()
	{
		return teacher;
	}
	public void setTeacher(Teacher teacher)
	{
		this.teacher = teacher;
	}
	public Parent getParent()
	{
		return parent;
	}
	public void setParent(Parent parent)
	{
		this.parent = parent;
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
