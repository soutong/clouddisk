package com.sxt.clouddisk.utils;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	public static SqlSession getSqlSession(){
		//1.���������ļ�mybatis-config.xml
		InputStream ips = null;
		try {
			ips = Resources.getResourceAsStream("mybatis-config.xml");//����·���¼���mybatis-config.xml����
		} catch (IOException e) {
			e.printStackTrace();
		}
		//2.����SqlSessoinFactoryBuilder����
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//3.����SqlSessoinFactoryBuilder������builder����,��ȡSqlSessionFactory����
		SqlSessionFactory sqlSessionFactory = builder.build(ips);
		//4.��ȡSqlSession����,����JDBC�е�Connection+PreparedStatement
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
