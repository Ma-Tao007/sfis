package com.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.entity.Parent;
import com.entity.Student;
import com.util.DBUtil;
import com.util.SQLUtil;

/**
 * 实现父母类的各种方法
 * 
 * @author OldFish
 * 
 */

public class ParentBean
{
	/**
	 * 家长注册
	 * 
	 * @return
	 */
	public boolean activate(String tel, String parName, String password,
			String stuNO)
	{
		String sql1 = "select * from student_tbl where stuNO=?";
		Object[] params1 = new Object[]
		{ stuNO };
		List<Map<String, Object>> result = SQLUtil.queryAsMap(sql1, params1);
		if (result.isEmpty() == false)
		{

			String sql = "insert into parent_tbl(tel,parName,password,stuNO) values(?,?,?,?)";
			Object[] params = new Object[]
			{ tel, parName, password, stuNO };
			int rowCount = SQLUtil.insert(sql, params);
			if (rowCount > 0)
			{
				return true;
			}
		}

		return false;
	}

	/**
	 * 家长登录
	 * 
	 * @return
	 */
	public Parent login(String tel, String password)
	{
		String sql = "select p.*,s.stuNO,s.stuName from parent_tbl p join student_tbl s on p.stuNO=s.stuNO where p.tel=? and p.password=? ";
		Object[] params = new Object[]
		{ tel, password };
		List<Map<String, Object>> result = SQLUtil.queryAsMap(sql, params);
		Parent parent = null;
		if (result.isEmpty() == false)
		{
			parent = new Parent();
			Map<String, Object> row = result.get(0);
			parent.setTel((String) row.get("tel").toString());
			parent.setParName((String) row.get("parName").toString());
			parent.setRole((String) row.get("role").toString());

			Student student = new Student();
			student.setStuNO((String) row.get("stuNO").toString());
			student.setStuName((String) row.get("stuName").toString());
			parent.setStudent(student);

			return parent;
		} else
			return null;
	}

	/**
	 * 显示家长列表
	 * 
	 * @return
	 */
	public List<Parent> parentList()
	{
		List<Parent> result = new ArrayList<Parent>();
		String sql = "select p.*,s.stuNO,s.stuName from parent_tbl p join student_tbl s on p.stuNO=s.stuNO";
		List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql, null);
		// 整理查询结果
		Parent parent = null;
		for (Map<String, Object> map : mapList)
		{
			parent = new Parent();
			parent.setParName((String) map.get("parName").toString());
			parent.setTel((String) map.get("tel").toString());

			Student student = new Student();
			student.setStuNO((String) map.get("stuNO").toString());
			student.setStuName((String) map.get("stuName").toString());
			parent.setStudent(student);

			result.add(parent);
		}

		return result;
	}

	/**
	 * 删除多个学生对应的家长
	 * 
	 * @param ids
	 * @return
	 */
	public boolean delete(String[] ids)
	{
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn
					.prepareStatement("delete from parent_tbl where stuNO = ?");
			for (String id : ids)
			{
				System.out.println(id);
				pstmt.setString(1, id);
				pstmt.addBatch();
			}

			int[] result = pstmt.executeBatch();
			if (result.length > 0)
			{
				flag = true;
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

	/**
	 * 显示确定学生的家长列表
	 * 
	 * @return
	 */
	public List<Parent> parent(String ids[])
	{
		List<Parent> result = new ArrayList<Parent>();
		String sql = "select * from parent_tbl where stuNO=?";
		for (int i = 0; i < ids.length; i++)
		{
			String[] params = new String[]
			{ ids[i] };
			List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql, params);
			// 整理查询结果
			Parent parent = null;
			if(mapList.size()==0)
			{
				return null;
			}
			Map<String, Object> map = mapList.get(0);
			parent = new Parent();
			parent.setParName((String) map.get("parName").toString());
			parent.setTel((String) map.get("tel").toString());
			result.add(parent);
		}

		return result;
	}
}
