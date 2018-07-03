package com.sxt.clouddisk.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sxt.clouddisk.mapper.FileInfosMapper;
import com.sxt.clouddisk.model.FileInfos;
import com.sxt.clouddisk.utils.MD5Utils;
import com.sxt.clouddisk.utils.MyBatisUtil;

public class FileInfosServiceImpl implements com.sxt.clouddisk.service.FileInfosService {
	
	/*private FileInfosDao fd=new FileInfosDaoImpl();
	public List<FileInfos> findByID(int userID) {
		// TODO Auto-generated method stub
		return fd.findByID(userID);
	}
	public int add(FileInfos fileInfos) {
		String fileLink = MD5Utils.createMD5(fileInfos.getFilePath());
		fileInfos.setFileLink(fileLink);
		return fd.add(fileInfos);
	}
	public int delete(int fileInfoID) {
		// TODO Auto-generated method stub
		return fd.delete(fileInfoID);
	}
	public FileInfos findByLink(String fileLink) {
		// TODO Auto-generated method stub
		return fd.findByLink(fileLink);
	}
*/
	public List<FileInfos> findByID(int userID) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		FileInfosMapper fileInfosMapper = sqlSession.getMapper(FileInfosMapper.class);
		return fileInfosMapper.findByID(userID);
	}
	public int add(FileInfos fileInfos) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		FileInfosMapper fileInfosMapper = sqlSession.getMapper(FileInfosMapper.class);
		String fileLink = MD5Utils.createMD5(fileInfos.getFilePath());
		fileInfos.setFileLink(fileLink);
		 int add = fileInfosMapper.add(fileInfos);
		 sqlSession.commit();
		 sqlSession.close();
		 return add;
	}
	public int delete(int fileInfoID) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		FileInfosMapper fileInfosMapper = sqlSession.getMapper(FileInfosMapper.class);
		 int delete = fileInfosMapper.delete(fileInfoID);
		 sqlSession.commit();
		 sqlSession.close();
		 return delete;
	}
	public FileInfos findByLink(String fileLink) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		FileInfosMapper fileInfosMapper = sqlSession.getMapper(FileInfosMapper.class);
		return fileInfosMapper.findByLink(fileLink);
	}
	
}
