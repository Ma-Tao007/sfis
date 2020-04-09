package com.bean;

import java.util.List;
import java.util.Map;

import com.entity.Student;
import com.entity.Teacher;
import com.util.SQLUtil;

/**
 * 找回密码类
 * @author Administrator
 *
 */

public class FindPassword
{

	/**
	 * 找回老师密码
	 * @return
	 */
	public Teacher findTeacherPassword(String id)
	{
		String sql="select tchName,password,tchEmail from teacher_tbl where tchNO=? and remark=?";
		Object[] params=new Object[]{id,"1"};
		List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql, params);
		Teacher teacher=null;
		if(mapList.isEmpty()==false)
		{
			Map<String,Object> map=mapList.get(0);
			teacher=new Teacher();
			teacher.setTchName((String)map.get("tchName").toString());
			teacher.setPassword((String)map.get("password").toString());
			teacher.setTchEmail((String)map.get("tchEmail").toString());
			
			return teacher;
		}
		
		return teacher;
		
	}
	
	/**
	 * 找回学生密码
	 * @return
	 */
	public Student findStudentPassword(String id)
	{
		String sql="select stuName,password,stuEmail from student_tbl where stuNO=? and remark=?";
		Object[] params=new Object[]{id,"1"};
		List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql, params);
		Student student=null;
		if(mapList.isEmpty()==false)
		{
			Map<String,Object> map=mapList.get(0);
			student=new Student();
			student.setStuName((String)map.get("stuName").toString());
			student.setPassword((String)map.get("password").toString());
			student.setStuEmail((String)map.get("stuEmail").toString());
			
			return student;
		}
		
		return student;
		
	}
	
}
