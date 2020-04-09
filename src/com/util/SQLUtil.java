package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLUtil
{
	public static List<Map<String, Object>> queryAsMap(String sql, Object[] params)
	{
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>(); // 查询结果

		// 声明 JDBC 操作对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (params != null)
			{
				int length = params.length;
				for (int i = 0; i < length; i++)
				{
					pstmt.setObject(i + 1, params[i]);
				}
			}
			// 执行查询
			rs = pstmt.executeQuery();

			// 获得查询结果中列的数量
			int columnCount = rs.getMetaData().getColumnCount();

			// 整理查询结果，存放到List<Object[]>中
			Map<String, Object> row = null;
			while (rs.next())
			{
				row = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++)
				{
					row.put(rs.getMetaData().getColumnLabel(i), rs.getObject(i));
				}
				result.add(row);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.close(conn, pstmt, rs);
		}

		return result;
	}
	
	/**
	 * 无参数 查询
	 * @param sql
	 * @return
	 */
	public static List<Object[]> query(String sql)
	{
		return query(sql, null);
	}

	/**
	 * 有参数 查询
	 * @param sql
	 * @param params
	 * @return
	 */
	public static List<Object[]> query(String sql, Object[] params)
	{
		List<Object[]> result = new ArrayList<Object[]>(); // 查询结果

		// 声明 JDBC 操作对象
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (params != null)
			{
				int length = params.length;
				for (int i = 0; i < length; i++)
				{
					pstmt.setObject(i + 1, params[i]);
				}
			}
			// 执行查询
			rs = pstmt.executeQuery();

			// 获得查询结果中列的数量
			int columnCount = rs.getMetaData().getColumnCount();

			// 整理查询结果，存放到List<Object[]>中
			Object[] row = null;
			while (rs.next())
			{
				row = new Object[columnCount];
				for (int i = 0; i < columnCount; i++)
				{
					row[i] = rs.getObject(i + 1);
				}
				result.add(row);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.close(conn, pstmt, rs);
		}

		return result;
	}
	
	public static Object[] uniqueQuery(String sql)
	{
		return uniqueQuery(sql, null);
	}
	
	public static Object[] uniqueQuery(String sql ,Object[] params)
	{
		List<Object[]> resultList = query(sql, params);
		if(resultList.isEmpty() == false)
			return resultList.get(0);
		return null;
	}
	
	/**
	 * 无参数 新增
	 * @param sql
	 * @return
	 */
	public static int insert(String sql)
	{
		return insert(sql, null);
	}
	
	/**
	 * 有参数 新增
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int insert(String sql, Object[] params)
	{
		return updateData(sql, params);
	}
	
	/**
	 * 无参数 更新
	 * @param sql
	 * @return
	 */
	public static int update(String sql)
	{
		return update(sql, null);
	}
	
	/**
	 * 有参数 新增
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int update(String sql, Object[] params)
	{
		return updateData(sql, params);
	}
	
	/**
	 * 无参数 删除
	 * @param sql
	 * @return
	 */
	public static int delete(String sql)
	{
		return delete(sql, null);
	}
	
	/**
	 * 有参数 删除
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int delete(String sql, Object[] params)
	{
		return updateData(sql, params);
	}

	/**
	 * 对数据有更改操作的方法，包括insert、update、delete操作
	 * @param sql
	 * @param params
	 * @return
	 */
	private static int updateData(String sql, Object[] params)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (params != null)
			{
				int length = params.length;
				for (int i = 0; i < length; i++)
				{
					pstmt.setObject(i + 1, params[i]);
				}
			}
			return pstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.close(conn, pstmt, rs);
		}

		return 0;
	}
}
