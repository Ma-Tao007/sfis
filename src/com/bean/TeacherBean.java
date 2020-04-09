package com.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.entity.Student;
import com.entity.Teacher;
import com.util.SQLUtil;

/**
 * 实现教师类的各种方法
 * @author OldFish
 *
 */

public class TeacherBean
{
	/**
	 * 验证教师是否存在
	 * @return
	 */
	public Teacher check(String tchNO)
	{
		String sql="select tchName from teacher_tbl where tchNO=?";
		Object[] params = new Object[]{tchNO};
		List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql, params);
		Teacher teacher=null;
		if(mapList.isEmpty()==false)
		{
			for (Map<String, Object> map : mapList)
			{
				teacher = new Teacher();
				teacher.setTchName((String)map.get("tchName").toString());
				return teacher;
			}
		}
		
		return null;
	}
	
	/**
	 * 激活教师
	 * @return
	 */
	public boolean activate(String password,String tchNO,String email)
	{
		String sql="update teacher_tbl set remark=?,password=?,tchEmail=? where tchNO=?";
		Object[] params = new Object[]{"1",password,email,tchNO};
		int rowCount=SQLUtil.update(sql, params);
		if (rowCount > 0)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * 教师登录
	 * @return
	 */
	public Teacher login(String tchNO,String password)
	{
		String sql="select * from teacher_tbl where tchNO=? and password=? and remark=?";
		Object[] params=new Object[]{tchNO,password,"1"};
		List< Map<String,Object> > result=SQLUtil.queryAsMap(sql, params);
		Teacher teacher=null;
		if(result.isEmpty()==false)
		{
			teacher=new Teacher();
			Map<String,Object> row=result.get(0);
			teacher.setTchNO((String)row.get("tchNO").toString());
			teacher.setTchName((String)row.get("tchName").toString());
			teacher.setTchEmail((String)row.get("tchEmail").toString());
			teacher.setRole((String)row.get("role").toString());
			
			return teacher;
		}
		else
			return null;
	}
	
	/**
	 * 添加教师
	 * @return
	 */
	public boolean save(Teacher teacher)
	{
		String sql = "insert into teacher_tbl(tchNO,tchName) values(?,?)";
		Object[] params = new Object[]
		{ teacher.getTchNO(),teacher.getTchName()};
		int rowCount = SQLUtil.insert(sql, params);
		if (rowCount > 0)
		{
			return true;
		}

		return false;
	}
	
	/**
	 * 显示教师列表
	 * 
	 * @return
	 */
	public List<Teacher> studentList()
	{
		List<Teacher> result = new ArrayList<Teacher>();
		String sql = "select * from teacher_tbl";
		List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql, null);
		// 整理查询结果
		Teacher teacher=null;// 临时变量
		for (Map<String, Object> map : mapList)
		{
			teacher = new Teacher();
			teacher.setTchNO((String)map.get("tchNO").toString());
			teacher.setTchName((String)map.get("tchName").toString());
			teacher.setRemark((String)map.get("remark").toString());
			
			result.add(teacher);
		}

		return result;
	}
	
}
