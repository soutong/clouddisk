package com.sxt.clouddisk.service;

import com.sxt.clouddisk.model.UserInfos;

public interface UserInfosService {
	public int register(UserInfos userInfos);
	public UserInfos login(String userName,String userPwd);
	public UserInfos findByName(String name);
}
