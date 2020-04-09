package com.jwillim.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil
{
	private static Context ctx;
	private static DataSource ds;

	static 
	{
		try
		{
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/OldFish_WebChat");
		} 
		catch (NamingException e)
		{
			e.printStackTrace();
		}

	}
	public static Connection getConnection()
	{
		try
		{
			return ds.getConnection();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public static void close(Connection conn, PreparedStatement pstmt,
			ResultSet rs)
	{
		try
		{
			if (rs != null)
				rs.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			if (conn != null)
				conn.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
