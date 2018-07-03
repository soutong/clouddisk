package com.sxt.clouddisk.service;

import java.util.List;

import com.sxt.clouddisk.model.FileInfos;

public interface FileInfosService {
	public List<FileInfos> findByID(int userID);
	public int add(FileInfos fileInfos);
	public int delete(int fileInfoID);
	public FileInfos findByLink(String fileLink);
}
