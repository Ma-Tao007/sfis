package com.jwillim.util;

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
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>(); // ��ѯ���

		// ���� JDBC �������
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
			// ִ�в�ѯ
			rs = pstmt.executeQuery();

			// ��ò�ѯ������е���
			int columnCount = rs.getMetaData().getColumnCount();

			// �����ѯ����ŵ�List<Object[]>��
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
	 * �޲��� ��ѯ
	 * @param sql
	 * @return
	 */
	public static List<Object[]> query(String sql)
	{
		return query(sql, null);
	}

	/**
	 * �в��� ��ѯ
	 * @param sql
	 * @param params
	 * @return
	 */
	public static List<Object[]> query(String sql, Object[] params)
	{
		List<Object[]> result = new ArrayList<Object[]>(); // ��ѯ���

		// ���� JDBC �������
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
			// ִ�в�ѯ
			rs = pstmt.executeQuery();

			// ��ò�ѯ������е���
			int columnCount = rs.getMetaData().getColumnCount();

			// �����ѯ����ŵ�List<Object[]>��
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
	
	/**
	 * �޲��� ����
	 * @param sql
	 * @return
	 */
	public static int insert(String sql)
	{
		return insert(sql, null);
	}
	
	/**
	 * �в��� ����
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int insert(String sql, Object[] params)
	{
		return updateData(sql, params);
	}
	
	/**
	 * �޲��� ����
	 * @param sql
	 * @return
	 */
	public static int update(String sql)
	{
		return update(sql, null);
	}
	
	/**
	 * �в��� ����
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int update(String sql, Object[] params)
	{
		return updateData(sql, params);
	}
	
	/**
	 * �޲��� ɾ��
	 * @param sql
	 * @return
	 */
	public static int delete(String sql)
	{
		return delete(sql, null);
	}
	
	/**
	 * �в��� ɾ��
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int delete(String sql, Object[] params)
	{
		return updateData(sql, params);
	}

	/**
	 * ������и�Ĳ���ķ�������(insert��update��delete����
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
