package com.sxt.clouddisk.service.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.sxt.clouddisk.dao.UsersInfosDao;
import com.sxt.clouddisk.mapper.UserInfosMapper;
import com.sxt.clouddisk.model.UserInfos;
import com.sxt.clouddisk.utils.MD5Utils;
import com.sxt.clouddisk.utils.MyBatisUtil;

public class UserInfosServiceImpl implements com.sxt.clouddisk.service.UserInfosService {
	/*private UsersInfosDao ud=new UserInfosDaoImpl();
	public int register(UserInfos userInfos) {
		String userPwd = MD5Utils.createMD5(userInfos.getUserPwd());
		userInfos.setUserPwd(userPwd);
		File file=new File("E:/upload/"+userInfos.getUserName());
		if(!file.exists()){
			file.mkdirs();
		}
		return ud.register(userInfos);
	}

	public UserInfos login(String userName, String userPwd) {
		userPwd = MD5Utils.createMD5(userPwd);
		return ud.login(userName, userPwd);
	}

	public UserInfos findByName(String name) {
		// TODO Auto-generated method stub
		return ud.findByName(name);
	}*/
	public int register(UserInfos userInfos) {
		String userPwd = MD5Utils.createMD5(userInfos.getUserPwd());
		userInfos.setUserPwd(userPwd);
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserInfosMapper usersInfosMapper = sqlSession.getMapper(UserInfosMapper.class);
		int register = usersInfosMapper.register(userInfos);
		sqlSession.commit();
		sqlSession.close();
		return register;
	}
	public UserInfos login(String userName, String userPwd) {
		userPwd = MD5Utils.createMD5(userPwd);
		/*HashMap<String, String> hm=new HashMap<String,String >();
		hm.put(userName, userPwd);*/
		UserInfos userInfos = new UserInfos();
		userInfos.setUserName(userName);
		userInfos.setUserPwd(userPwd);
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserInfosMapper usersInfosMapper = sqlSession.getMapper(UserInfosMapper.class);
		return  usersInfosMapper.login(userInfos);
	}
	public UserInfos findByName(String name) {
	SqlSession sqlSession = MyBatisUtil.getSqlSession();
	UserInfosMapper userInfosMapper = sqlSession.getMapper(UserInfosMapper.class);
		return userInfosMapper.findByName(name);
	} 
}
