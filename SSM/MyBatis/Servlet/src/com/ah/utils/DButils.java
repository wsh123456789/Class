package com.ah.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DButils {

	static SqlSession openSession = null;

	public static SqlSession before() {
		// 加载配置文件
		InputStream resourceAsStream;
		try {
			resourceAsStream = Resources.getResourceAsStream("mybatis_config.xml");
			// 创建SqlSessionFactoryBuilder对象 该对象可以创建sql会话工厂
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			// 创建sqlsession工厂
			SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
			openSession = build.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return openSession;
	}

	// 提交和关闭
	public static void after() {
		openSession.commit();
	}

}
