package com.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.entity.Message;
import com.entity.Parent;
import com.entity.Reply;
import com.entity.Student;
import com.util.DBUtil;
import com.util.SQLUtil;

/**
 * 实现回复类的各种方法
 * @author OldFish
 *
 */

public class ReplyBean
{
	
	/**
	 * 回复留言
	 * @param message
	 * @return
	 */
	public boolean save(Reply reply)
	{
		String sql = "insert into reply_tbl(content,replyTime,replyerID,messageID) values(?,?,?,?)";
		Object[] params = new Object[]
		{reply.getContent(),reply.getReplyTime(),reply.getReplyID(),reply.getMessage().getId() };
		int rowCount = SQLUtil.insert(sql, params);
		if (rowCount > 0)
		{
			return true;
		}

		return false;
	}
	
	/**
	 * 显示所有回复
	 * @return
	 */
	public List<Reply> replyAllList()
	{
		System.out.println("************");
		List<Reply> result=new ArrayList<Reply>();
		String sql="select * from reply_tbl ";
		List<Map<String,Object>> mapList= SQLUtil.queryAsMap(sql, null);
		Reply reply=null;
		for(Map<String,Object> map:mapList)
		{
			reply=new Reply();
			reply.setId(Integer.parseInt(map.get("id").toString()));
			reply.setContent(map.get("content").toString());
			
			Message message=new Message();
			message.setId(Integer.parseInt(map.get("messageID").toString()));
			reply.setMessage(message);
			
			reply.setReplyID(map.get("replyerID").toString());
			
			result.add(reply);
		}
		return result;
	}
	
	/**
	 * 根据留言的id,查询回复帖子信息
	 * 
	 * @return
	 */
	public Reply load(String id)
	{

		String sql = "select * from reply_tbl where messageID=?";
		Object[] params = new Object[]
		{id};
		List<Map<String, Object>> result = SQLUtil.queryAsMap(sql, params);
		Reply reply=null;
		if (result.isEmpty() == false)
		{
			Map<String, Object> row = result.get(0);
			reply=new Reply();
			reply.setContent((String)row.get("content").toString());
//			reply.setReplyTime((String)row.get("content").toString());
			
			return reply;
		}
		
		return reply;
	}
	
	/**
	 * 根据留言id，显示相应的回帖列表
	 * @param id
	 * @return
	 */
	public List<Reply> replyList(String id)
	{
		List<Reply> result = new ArrayList<Reply>();
		String sql = "select * from reply_tbl where messageID=?";
		Object[] params=new Object[]{id};
		List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql, params);
		// 整理查询结果
		Reply reply=null;
		for (Map<String, Object> map : mapList)
		{
			reply = new Reply();
			reply.setContent((String)map.get("content").toString());
			
			
			result.add(reply);
		}

		return result;
	}
	/**
	 * 删除多条学生留言记录
	 * @param ids
	 * @return
	 */
	public boolean deleteSM(String[] ids)
	{
		boolean flag=false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("delete from reply_tbl where replyerID = ?");
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
	
	/**
	 * 删除多条家长留言记录留言记录
	 * @param ids
	 * @return
	 */
	public boolean deletePM(List<String> ids)
	{
		boolean flag=false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try
		{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("delete from reply_tbl where replyerID = ?");
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
	
	/**
	 * 删除多条回复
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
			pstmt = conn.prepareStatement("delete from reply_tbl where id = ?");
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
