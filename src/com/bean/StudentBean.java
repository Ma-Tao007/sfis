package com.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.entity.Parent;
import com.entity.Student;
import com.entity.Teacher;
import com.util.DBUtil;
import com.util.SQLUtil;

/**
 * 实现学生类的各种方法
 * @author OldFish
 *
 */

public class StudentBean
{
	
	/**
	 * 验证学生是否存在
	 * @return
	 */
	public Student check(String stuNO)
	{
		String sql="select stuName from student_tbl where stuNO=?";
		Object[] params = new Object[]{stuNO};
		List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql, params);
		Student student=null;
		if(mapList.isEmpty()==false)
		{
			for (Map<String, Object> map : mapList)
			{
				student = new Student();
				student.setStuName((String)map.get("stuName").toString());
				return student;
			}
		}
		
		return null;
	}
	
	/**
	 * 激活学生
	 * @return
	 */
	public boolean activate(String password,String stuNO,String email)
	{
		String sql="update student_tbl set remark=?,password=?,stuEmail=? where stuNO=?";
		Object[] params = new Object[]{"1",password,email,stuNO};
		int rowCount=SQLUtil.update(sql, params);
		if (rowCount > 0)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * 学生登录
	 * @return
	 */
	public Student login(String stuNO,String password)
	{
		String sql="select * from student_tbl where stuNO=? and password=? and remark=?";
		Object[] params=new Object[]{stuNO,password,"1"};
		List< Map<String,Object> > result=SQLUtil.queryAsMap(sql, params);
		Student student=null;
		if(result.isEmpty()==false)
		{
			student=new Student();
			Map<String,Object> row=result.get(0);
			student.setStuNO((String)row.get("stuNO").toString());
			student.setStuName((String)row.get("stuName").toString());
			student.setStuEmail((String)row.get("stuEmail").toString());
			student.setRole((String)row.get("role").toString());
			student.setGender((String)row.get("gender").toString());
			student.setStuClass((String)row.get("stuClass").toString());
			student.setDepartment((String)row.get("department").toString());
			
			return student;
		}
		else
			return null;
	}
	
	/**
	 * 添加学生
	 * @return
	 */
	public boolean save(Student student)
	{
		String sql = "insert into student_tbl(stuNO,stuName) values(?,?)";
		Object[] params = new Object[]
		{ student.getStuNO(),student.getStuName() };
		int rowCount = SQLUtil.insert(sql, params);
		if (rowCount > 0)
		{
			return true;
		}

		return false;
	}
	
	/**
	 * 显示学生列表
	 * 
	 * @return
	 */
	public List<Student> studentList()
	{
		List<Student> result = new ArrayList<Student>();
		String sql = "select s.*,p.tel from student_tbl s left join parent_tbl p on s.stuNO=p.stuNO";
		List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql, null);
		// 整理查询结果
		Student student=null;// 临时变量
		for (Map<String, Object> map : mapList)
		{
			student = new Student();
			student.setStuNO((String)map.get("stuNO").toString());
			student.setStuName((String)map.get("stuName").toString());
			student.setRemark((String)map.get("remark").toString());
			
			Parent parent=new Parent();
			if(map.get("tel")==null)
			{
				parent.setTel("1");
			}
			else
			{
				parent.setTel((String)map.get("tel").toString());
				
			}
			student.setParent(parent);
			result.add(student);
				
		}

		return result;
	}
	
	/**
	 * 删除多条学生
	 * @param ids
	 * @return
	 */
	public boolean delete(String[] ids)
	{
		boolean flag=false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("delete from student_tbl where stuNO = ?");
			for (String id : ids)
			{
				System.out.println(id);
				pstmt.setString(1, id);
				pstmt.addBatch();
			}

			int[] result = pstmt.executeBatch();
			if (result.length > 0)
			{
				flag=true;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtil.close(conn, pstmt, null);
		}
		return flag;
	}
	
}
