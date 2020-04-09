package com.jwillim.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SQLQueryUtil
{
	
	
	public static List<Object[]> getResult(String sql)
	{
		return getResult(sql,null);
	}

	public static List<Object[]> getResult(String sql ,Object params)
	{
		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;
		conn = DBUtil.getConnection();
		try
		{
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;

	}
}
