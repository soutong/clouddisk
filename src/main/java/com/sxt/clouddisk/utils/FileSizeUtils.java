package com.sxt.clouddisk.utils;

import java.io.File;

public class FileSizeUtils {
	//定义成员变量，用于累加文件大小  
	public long size = 0;  
	//统计目录大小的方法  
	public void getDirSize(File file) {  
	    if(file.isFile()) {  
	        //如果是文件，获取文件大小累加  
	        size += file.length();  
	    }else if(file.isDirectory()) {  
	        //获取目录中的文件及子目录信息  
	        File[] f1 = file.listFiles();  
	        for(int i = 0; i < f1.length; i++) {  
	            //调用递归遍历f1数组中的每一个对象  
	            getDirSize(f1[i]);  
	        }  
	    }  
	}
}
