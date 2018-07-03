package com.sxt.clouddisk.utils;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	public static SqlSession getSqlSession(){
		//1.加载配置文件mybatis-config.xml
		InputStream ips = null;
		try {
			ips = Resources.getResourceAsStream("mybatis-config.xml");//从类路径下加载mybatis-config.xml配置
		} catch (IOException e) {
			e.printStackTrace();
		}
		//2.创建SqlSessoinFactoryBuilder对象
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//3.调用SqlSessoinFactoryBuilder对象中builder方法,获取SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = builder.build(ips);
		//4.获取SqlSession对象,类似JDBC中的Connection+PreparedStatement
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
