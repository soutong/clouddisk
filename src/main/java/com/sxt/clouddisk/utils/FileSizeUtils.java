package com.sxt.clouddisk.utils;

import java.io.File;

public class FileSizeUtils {
	//�����Ա�����������ۼ��ļ���С  
	public long size = 0;  
	//ͳ��Ŀ¼��С�ķ���  
	public void getDirSize(File file) {  
	    if(file.isFile()) {  
	        //������ļ�����ȡ�ļ���С�ۼ�  
	        size += file.length();  
	    }else if(file.isDirectory()) {  
	        //��ȡĿ¼�е��ļ�����Ŀ¼��Ϣ  
	        File[] f1 = file.listFiles();  
	        for(int i = 0; i < f1.length; i++) {  
	            //���õݹ����f1�����е�ÿһ������  
	            getDirSize(f1[i]);  
	        }  
	    }  
	}
}
