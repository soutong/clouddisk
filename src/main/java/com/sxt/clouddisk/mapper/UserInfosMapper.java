package com.sxt.clouddisk.mapper;

import java.util.HashMap;

import com.sxt.clouddisk.model.UserInfos;

public interface UserInfosMapper {
		public int register(UserInfos userInfos);
		//public UserInfos login(HashMap<String,String> hm);
		public UserInfos login(UserInfos userInfos);
		public UserInfos findByName(String name);
}
