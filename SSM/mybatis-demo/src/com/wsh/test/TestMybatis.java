package com.wsh.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wsh.bean.User;

public class TestMybatis {

	public static void main(String[] args) throws IOException {
		//加载配置文件
		InputStream resourceAsStream = Resources.getResourceAsStream("mybatis_config.xml");
		
		//创建SqlSessionFactoryBuilder对象  该对象可以创建sql会话工厂
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		
		//创建sqlsession工厂
		SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
		
		SqlSession openSession = build.openSession();
		
		User object = openSession.selectOne("selectUserById", 1);
		System.out.println(object);
	}
}
