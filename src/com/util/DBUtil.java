package com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			ds = (DataSource) ctx.lookup("java:comp/env/SFIS");
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
	
	public static void close(Connection conn, Statement stmt, ResultSet rs)
	{
		try
		{
			if(rs != null)
				rs.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			if(stmt != null)
				stmt.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			if(conn != null)
				conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
