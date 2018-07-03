package com.sxt.clouddisk.dao;

import java.util.HashMap;

import com.sxt.clouddisk.model.UserInfos;

public interface UsersInfosDao {
	public int register(UserInfos userInfos);
	public UserInfos login(HashMap<String,String> hm);
	public UserInfos findByName(String name);
}
