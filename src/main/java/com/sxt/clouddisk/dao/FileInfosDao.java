package com.sxt.clouddisk.dao;

import java.util.List;

import com.sxt.clouddisk.model.FileInfos;

public interface FileInfosDao {
	public List<FileInfos> findByID(int userID);
	public int add(FileInfos fileInfos);
	public int delete(int fileInfoID);
	public FileInfos findByLink(String fileLink);
}
