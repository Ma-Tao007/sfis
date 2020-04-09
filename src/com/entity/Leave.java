package com.entity;

import java.util.Date;

/**
 * 请假封装类
 * @author OldFish
 *
 */

public class Leave
{
	private String content;// 请假内容
	private Date start;// 请假开始时间
	private Date end;// 请假结束时间
	private String remark;// 审批假条标记
	private Student student;
	private Teacher teacher;
	
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public Date getStart()
	{
		return start;
	}
	public void setStart(Date start)
	{
		this.start = start;
	}
	public Date getEnd()
	{
		return end;
	}
	public void setEnd(Date end)
	{
		this.end = end;
	}
	public String getRemark()
	{
		return remark;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public Student getStudent()
	{
		return student;
	}
	public void setStudent(Student student)
	{
		this.student = student;
	}
	public Teacher getTeacher()
	{
		return teacher;
	}
	public void setTeacher(Teacher teacher)
	{
		this.teacher = teacher;
	}
}
