package com.sxt.clouddisk.model;

import java.util.Date;

public class FileInfos {
	private int fileInfoID;
	private String fileName;
	private Date createDate;
	private int fileSize;
	private  String fileLink;
	private String filePath;
	public int getFileInfoID() {
		return fileInfoID;
	}
	public void setFileInfoID(int fileInfoID) {
		this.fileInfoID = fileInfoID;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileLink() {
		return fileLink;
	}
	public void setFileLink(String fileLink) {
		this.fileLink = fileLink;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	private int userID;
	
}
