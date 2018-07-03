package com.sxt.clouddisk.dao.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class BaseDao {
	
private final String Dbdriver="com.mysql.jdbc.Driver";
private final String URL="jdbc:mysql://localhost:3306/clouddisk";
private final String USERNAME="root";
private final String PASSWORD="mysqladmin";
private Connection con;
private PreparedStatement prep;
public ResultSet rs;
public void getCon(){
	try {
		Class.forName(Dbdriver);
		con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void closeAll(){
	try {
	if(rs!=null){
			rs.close();
	}
	if(prep!=null){
		prep.close();
	}
	if(con!=null){
		con.close();
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
public int excuteUpdate(String sql,String arry[]){
	this.getCon();
	int count=0;
	try {
		prep=con.prepareStatement(sql);
		if(arry!=null&&arry.length>0){
			for(int i=0;i<arry.length;i++){
				prep.setString(i+1, arry[i]);
			}
		}
		 count=prep.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		this.closeAll();
	}
	return count;
	
}
public ResultSet excuteQuery(String sql,String arry[]){
	this.getCon();
	ResultSet rs=null;
	try {
		prep=con.prepareStatement(sql);
		if(arry!=null&&arry.length>0){
			for(int i=0;i<arry.length;i++){
				prep.setString(i+1, arry[i]);
			}
		}
		rs=prep.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return rs;
	
	
}
}

