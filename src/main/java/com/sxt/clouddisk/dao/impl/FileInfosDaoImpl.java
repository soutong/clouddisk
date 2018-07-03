package com.sxt.clouddisk.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sxt.clouddisk.dao.FileInfosDao;
import com.sxt.clouddisk.model.FileInfos;

public class FileInfosDaoImpl extends BaseDao implements FileInfosDao{

	public List<FileInfos> findByID(int userID) {
		String sql="select * from fileinfos where userID="+userID;
		List<FileInfos> list=new ArrayList<FileInfos> ();
		ResultSet rs = this.excuteQuery(sql, null);
		try {
			while(rs.next()){
				FileInfos fileInfos = new FileInfos();
				fileInfos.setCreateDate(rs.getDate("createDate"));
				fileInfos.setFileInfoID(rs.getInt("fileInfoID"));
				fileInfos.setFileLink(rs.getString("fileLink"));
				fileInfos.setFileName(rs.getString("fileName"));
				fileInfos.setFilePath(rs.getString("filePath"));
				fileInfos.setFileSize(rs.getInt("fileSize"));
				fileInfos.setUserID(rs.getInt("userID"));
				list.add(fileInfos);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll();
		}
		return list;
	}

	public int add(FileInfos fileInfos) {
		String sql="insert into fileInfos (fileName,createDate,fileSize,fileLink,filePath,userID) values(?,now(),?,?,?,?)";
		String arry[]={fileInfos.getFileName(),fileInfos.getFileSize()+"",fileInfos.getFileLink(),fileInfos.getFilePath(),fileInfos.getUserID()+""};
		return this.excuteUpdate(sql, arry);
	}

	public int delete(int fileInfoID) {
		String sql="delete from fileinfos where fileInfoID="+fileInfoID;
		return this.excuteUpdate(sql, null);
	}

	public FileInfos findByLink(String fileLink) {
		String sql="select * from fileInfos where fileLink=?";
		String arry[]={fileLink};
		ResultSet rs = this.excuteQuery(sql, arry);
		FileInfos fileInfos = null;
		try {
			while(rs.next()){
				fileInfos=new FileInfos();
				fileInfos.setCreateDate(rs.getDate("createDate"));
				fileInfos.setFileInfoID(rs.getInt("fileInfoID"));
				fileInfos.setFileLink(rs.getString("fileLink"));
				fileInfos.setFileName(rs.getString("fileName"));
				fileInfos.setFilePath(rs.getString("filePath"));
				fileInfos.setFileSize(rs.getInt("fileSize"));
				fileInfos.setUserID(rs.getInt("userID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll();
		}
		return fileInfos;
	}

}
