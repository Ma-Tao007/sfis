package com.entity;

/**
 * 成绩封装类
 * @author OldFish
 *
 */

public class Score
{
	private Student student;
	private String course;// 课程名
	private int score;// 成绩分数
	
	public Student getStudent()
	{
		return student;
	}
	public void setStudent(Student student)
	{
		this.student = student;
	}
	public String getCourse()
	{
		return course;
	}
	public void setCourse(String course)
	{
		this.course = course;
	}
	public int getScore()
	{
		return score;
	}
	public void setScore(int score)
	{
		this.score = score;
	}
}
