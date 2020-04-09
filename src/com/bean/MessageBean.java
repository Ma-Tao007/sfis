package com.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.entity.Message;
import com.entity.Parent;
import com.entity.Student;
import com.entity.Teacher;
import com.util.DBUtil;
import com.util.DateUtil;
import com.util.SQLUtil;

/**
 * 实现留言类的各种方法
 * @author OldFish
 *
 */

public class MessageBean
{
	/**
	 * 发表留言
	 * @param message
	 * @return
	 */
	public boolean save(Message message)
	{
		String sql = "insert into message_tbl(title,content,sendTime,senderID,receiverID,remark) values(?,?,?,?,?,?)";
		Object[] params = new Object[]
		{ message.getTitle(),message.getContent(),message.getSendTime(),message.getSenderID(),message.getReceiverID(),"0" };
		int rowCount = SQLUtil.insert(sql, params);
		if (rowCount > 0)
		{
			return true;
		}

		return false;
	}
	
	/**
	 * 显示所有留言
	 * @return
	 */
	public List<Message> messageAllList()
	{
		System.out.println("************");
		List<Message> result=new ArrayList<Message>();
		String sql="select * from message_tbl order by sendTime desc";
		List<Map<String,Object>> mapList= SQLUtil.queryAsMap(sql, null);
		Message message=null;
		for(Map<String,Object> map:mapList)
		{
			message=new Message();
			message.setId(Integer.parseInt(map.get("id").toString()));
			message.setTitle((String)map.get("title").toString());
			message.setSenderID((String)map.get("senderID").toString());
			message.setReceiverID((String)map.get("receiverID").toString());
			
			result.add(message);
		}
		return result;
	}
	
	/**
	 * 判断留言是否已读
	 * @return
	 */
	public List<String> remarkList()
	{
		List<String> result=new ArrayList<String>();
		String sql="select remark from message_tbl ";
		List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql,null);
		
		return result;
	}
	
	/**
	 * 显示学生给教师的留言列表
	 * 
	 * @return
	 */
	public List<Message> messageList1(String tchNO)
	{
		List<Message> result = new ArrayList<Message>();
		String sql = "select m.*,s.stuName from message_tbl m join student_tbl s on m.senderID=s.stuNO where m.receiverID=? order by sendTime desc";
		Object[] params=new Object[]{tchNO};
		List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql, params);
		// 整理查询结果
		Message message=null;// 临时变量
		for (Map<String, Object> map : mapList)
		{
			message = new Message();
			message.setId(Integer.parseInt(map.get("id").toString()));
			message.setTitle((String)map.get("title").toString());
			message.setRemark((String)map.get("remark").toString());
			
			Student student=new Student();
			student.setStuName((String)map.get("stuName").toString());
			message.setStudent(student);
			
			result.add(message);
		}

		return result;
	}
	
	/**
	 * 显示教师给学生的留言列表
	 * 
	 * @return
	 */
	public List<Message> messageList2(String stuNO)
	{
		List<Message> result = new ArrayList<Message>();
		String sql = "select m.*,t.tchName from message_tbl m join teacher_tbl t on m.senderID=t.tchNO where m.receiverID=? order by sendTime desc";
		Object[] params=new Object[]{stuNO};
		List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql, params);
		// 整理查询结果
		Message message=null;// 临时变量
		for (Map<String, Object> map : mapList)
		{
			message = new Message();
			message.setId(Integer.parseInt(map.get("id").toString()));
			message.setTitle((String)map.get("title").toString());
			message.setRemark((String)map.get("remark").toString());
			
			Teacher teacher=new Teacher();
			teacher.setTchName((String)map.get("tchName").toString());
			message.setTeacher(teacher);
			
			result.add(message);
		}

		return result;
	}
	
	/**
	 * 显示家长给教师的留言列表
	 * 
	 * @return
	 */
	public List<Message> messageList3(String tchNO)
	{
		List<Message> result = new ArrayList<Message>();
		String sql = "select m.*,p.parName from message_tbl m join parent_tbl p on m.senderID=p.tel where m.receiverID=? order by sendTime desc";
		Object[] params=new Object[]{tchNO};
		List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql, params);
		// 整理查询结果
		Message message=null;// 临时变量
		for (Map<String, Object> map : mapList)
		{
			message = new Message();
			message.setId(Integer.parseInt(map.get("id").toString()));
			message.setTitle((String)map.get("title").toString());
			message.setRemark((String)map.get("remark").toString());
			
			Parent parent=new Parent();
			parent.setParName((String)map.get("parName").toString());
			message.setParent(parent);
			
			result.add(message);
		}

		return result;
	}
	
	/**
	 * 显示教师给家长的留言列表
	 * 
	 * @return
	 */
	public List<Message> messageList4(String tel)
	{
		List<Message> result = new ArrayList<Message>();
		String sql = "select m.*,t.tchName from message_tbl m join teacher_tbl t on m.senderID=t.tchNO where m.receiverID=? order by sendTime desc";
		Object[] params=new Object[]{tel};
		List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql, params);
		// 整理查询结果
		Message message=null;// 临时变量
		for (Map<String, Object> map : mapList)
		{
			message = new Message();
			message.setId(Integer.parseInt(map.get("id").toString()));
			message.setTitle((String)map.get("title").toString());
			message.setRemark((String)map.get("remark").toString());
			
			Teacher teacher=new Teacher();
			teacher.setTchName((String)map.get("tchName").toString());
			message.setTeacher(teacher);
			
			result.add(message);
		}

		return result;
	}
	
	/**
	 * 根据id查询留言信息
	 * @param id
	 * @throws ParseException 
	 */
	public Message load(String id) throws ParseException
	{

		String sql = "select * from message_tbl where id=?";
		Object[] params = new Object[]
		{ id };
		List<Map<String, Object>> result = SQLUtil.queryAsMap(sql, params);
		Message message=null;
		if (result.isEmpty() == false)
		{
			Map<String, Object> row = result.get(0);
			message=new Message();
			message.setTitle((String)row.get("title").toString());
			message.setContent((String)row.get("content").toString());
			Date sendTime=DateUtil.parseDateString((String)row.get("sendTime").toString());
			message.setSendTime(sendTime);
			
			return message;
		}
		return null;
	}
	
	/**
	 * 留言已读
	 * @param id
	 */
	public void read(String id)
	{
		System.out.println("****"+id);
		String sql="update message_tbl set remark=? where id=?";
		Object[] params=new Object[]{"1",id};
		SQLUtil.insert(sql, params);
	}
	
	/**
	 * 学生发的所有留言
	 * @return
	 */
	public List<Message> studentMessageList(String stuNO)
	{
		List<Message> result = new ArrayList<Message>();
		String sql="select m.*,t.tchNO,t.tchName from message_tbl m join teacher_tbl t on m.receiverID=t.tchNO where m.senderID=? order by sendTime desc";
		Object[] params=new Object[]{stuNO};
		List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql, params);
		Message message=null;
		for (Map<String, Object> map : mapList)
		{
			message = new Message();
			message.setId(Integer.parseInt(map.get("id").toString()));
			message.setTitle((String)map.get("title").toString());
			message.setRemark((String)map.get("remark").toString());
			
			Teacher teacher=new Teacher();
			teacher.setTchNO((String)map.get("tchNO").toString());
			teacher.setTchName((String)map.get("tchName").toString());
			message.setTeacher(teacher);
			
			result.add(message);
		}
		
		return result;
	}
	
	/**
	 * 家长发的所有留言
	 * @return
	 */
	public List<Message> parentMessageList(String tel)
	{
		List<Message> result = new ArrayList<Message>();
		String sql = "select m.*,t.tchNO,t.tchName from message_tbl m join teacher_tbl t on m.receiverID=t.tchNO where m.senderID=? order by sendTime desc";
		Object[] params=new Object[]{tel};
		List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql, params);
		// 整理查询结果
		Message message=null;// 临时变量
		for (Map<String, Object> map : mapList)
		{
			message = new Message();
			message.setId(Integer.parseInt(map.get("id").toString()));
			message.setTitle((String)map.get("title").toString());
			message.setRemark((String)map.get("remark").toString());
			
			Teacher teacher=new Teacher();
			teacher.setTchNO((String)map.get("tchNO").toString());
			teacher.setTchName((String)map.get("tchName").toString());
			message.setTeacher(teacher);
			
			result.add(message);
		}
		
		return result;
	}
	
	/**
	 * 教师发给学生的所有留言
	 * 
	 * @return
	 */
	public List<Message> teacherMessageList1(String tchNO)
	{
		List<Message> result = new ArrayList<Message>();
		String sql = "select m.*,s.stuNO,s.stuName from message_tbl m join student_tbl s on m.receiverID=s.stuNO where m.senderID=? order by sendTime desc";
		Object[] params=new Object[]{tchNO};
		List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql, params);
		// 整理查询结果
		Message message=null;// 临时变量
		for (Map<String, Object> map : mapList)
		{
			message = new Message();
			message.setId(Integer.parseInt(map.get("id").toString()));
			message.setTitle((String)map.get("title").toString());
			message.setRemark((String)map.get("remark").toString());
			
			Student student=new Student();
			student.setStuNO((String)map.get("stuNO").toString());
			student.setStuName((String)map.get("stuName").toString());
			message.setStudent(student);
			
			result.add(message);
		}

		return result;
	}
	
	/**
	 * 教师发给家长所有留言
	 * 
	 * @return
	 */
	public List<Message> teacherMessageList2(String tchNO)
	{
		List<Message> result = new ArrayList<Message>();
		String sql = "select m.*,p.tel,p.parName from message_tbl m join parent_tbl p on m.receiverID=p.tel where m.senderID=? order by sendTime desc";
		Object[] params=new Object[]{tchNO};
		List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql, params);
		// 整理查询结果
		Message message=null;// 临时变量
		for (Map<String, Object> map : mapList)
		{
			message = new Message();
			message.setId(Integer.parseInt(map.get("id").toString()));
			message.setTitle((String)map.get("title").toString());
			message.setRemark((String)map.get("remark").toString());
			
			Parent parent=new Parent();
			parent.setTel((String)map.get("tel").toString());
			parent.setParName((String)map.get("tel").toString());
			message.setParent(parent);
			
			result.add(message);
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
			pstmt = conn.prepareStatement("delete from message_tbl where senderID = ?");
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
			pstmt = conn.prepareStatement("delete from message_tbl where senderID = ?");
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
