package com.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.entity.Admin;
import com.entity.Parent;
import com.entity.Student;
import com.util.SQLUtil;

/**
 * 实现管理员类的各种方法
 * @author OldFish
 *
 */

public class AdminBean
{
	//public Admin admin;
	/**
	 * 管理员登录
	 * @param admin
	 * @return
	 */
	public boolean login(Admin admin)
	{
		
		String sql="select * from admin_tbl where adminName=? and password=? ";
		Object[] params=new Object[]{admin.getAdminName(),admin.getPassword()};
		List< Map<String,Object> > result=SQLUtil.queryAsMap(sql, params);
		if(result.isEmpty()==false)
		{
			Map<String,Object> row=result.get(0);
			admin.setAdminName((String)row.get("adminName"));
			admin.setAdminEmail((String)row.get("adminEmail"));
			
			return true;
		}
		else
			return false;
	}
	
	/**
	 * 添加管理员
	 * @return
	 */
	public boolean save(Admin admin)
	{
		String sql = "insert into admin_tbl(adminName,password) values(?,?)";
		Object[] params = new Object[]
		{ admin.getAdminName(),admin.getAdminName() };
		int rowCount = SQLUtil.insert(sql, params);
		if (rowCount > 0)
		{
			return true;
		}

		return false;
	}
	
	/**
	 * 显示管理员列表
	 * 
	 * @return
	 */
	public List<Admin> adminList()
	{
		List<Admin> result = new ArrayList<Admin>();
		String sql = "select * from admin_tbl";
		List<Map<String, Object>> mapList = SQLUtil.queryAsMap(sql, null);
		// 整理查询结果
		Admin admin=null;// 临时变量
		for (Map<String, Object> map : mapList)
		{
			admin = new Admin();
			admin.setId(Integer.parseInt(map.get("id").toString()));
			admin.setAdminName((String)map.get("adminName").toString());
			
			result.add(admin);
		}

		return result;
	}
	
}
