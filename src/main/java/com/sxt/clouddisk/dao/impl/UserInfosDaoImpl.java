package com.sxt.clouddisk.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.sxt.clouddisk.dao.UsersInfosDao;
import com.sxt.clouddisk.model.UserInfos;

public class UserInfosDaoImpl extends BaseDao implements UsersInfosDao {

	public int register(UserInfos userInfos) {
		String sql="insert into userinfos (userName,userPwd,userType) values(?,?,?)";
		String arry[]={userInfos.getUserName(),userInfos.getUserPwd(),userInfos.getUserType()+""};
		return this.excuteUpdate(sql, arry);
	}

	public UserInfos login(String userName, String userPwd) {
		String sql="select * from userinfos where userName='"+userName+"' and userPwd='"+userPwd+"'";
		ResultSet rs = this.excuteQuery(sql, null);
		UserInfos userInfos=null;
		try {
			while(rs.next()){
				userInfos=new UserInfos();
				userInfos.setUserID(rs.getInt("userID"));
				userInfos.setUserName(rs.getString("userName"));
				userInfos.setUserPwd(rs.getString("userPwd"));
				userInfos.setUserType(rs.getInt("userType"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll();
		}
		
		return userInfos;
	}

	public UserInfos findByName(String name) {
		String sql="select * from userinfos where userName ="+name;
		ResultSet rs = this.excuteQuery(sql, null);
		UserInfos userInfos=null;
		try {
			while(rs.next()){
				userInfos=new UserInfos();
				userInfos.setUserID(rs.getInt("userID"));
				userInfos.setUserName(rs.getString("userName"));
				userInfos.setUserPwd(rs.getString("userPwd"));
				userInfos.setUserType(rs.getInt("userType"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll();
		}
		return userInfos;
	}

	public UserInfos login(HashMap<String, String> hm) {
		// TODO Auto-generated method stub
		return null;
	}

}
