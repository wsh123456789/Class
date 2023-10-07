package com.wsh.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.wsh.bean.User;
import com.wsh.mapper.UserMapper;

public class TestDemo {
	SqlSession openSession = null;

	@Before
	public void before() throws IOException {
		// 加载配置文件
		InputStream resourceAsStream = Resources.getResourceAsStream("mybatis_config.xml");

		// 创建SqlSessionFactoryBuilder对象 该对象可以创建sql会话工厂
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

		// 创建sqlsession工厂
		SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);

		openSession = build.openSession();

		// User object = openSession.selectOne("selectUserById", 1);

		// List<User> object = openSession.selectList("selectUserById1",3);
	}

	@Test
	@Ignore // 忽略此测试 类似注释
	public void test() {
		System.out.println("我是test");
	}

	@Test
	@Ignore
	public void test2() {
		List<User> object = openSession.selectList("selectUserById2");
		System.out.println(object);
	}
	
	@Test
	@Ignore
	public void test3() {
	    UserMapper mapper = openSession.getMapper(UserMapper.class);
	    // 查询所有
	    List<User> userList = mapper.getUserAll();
	    System.out.println("查询所有" + userList);
	    // 按条件查询查询
	    // 传具体值查询
	    String username = "admin";
	    String password = "123";
	    List<User> user = mapper.getUserByUsernameAndPassword(username,password);
 		System.out.println("具体值查询" + user);
 		// 传对象查询
 		User user1 = new User();
 		user1.setUsername(username);
 		user1.setPassword(password);
 		List<User> userShow1 = mapper.getUserByUser(user1);
 		System.out.println("传对象查询" + userShow1);
 		// 传集合查询
 		HashMap<String, String> hash = new HashMap<String, String>();
 		hash.put("username", "admin");
 		hash.put("password", "123");
 		List<User> userShow2 = mapper.getUserByList(hash);
 		System.out.println("传列表查询" + userShow2);
 		
 	}
	
	@Test
	@Ignore
	public void test4() {
		// 增加
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("Angus");
		user.setAge(23);
		user.setPassword("123456");
		user.setSex("男");
		Integer count = mapper.addUser(user);
		System.out.println(count);
	}
	
	@Test
	@Ignore
	public void test5() {
		// 修改
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		User user = new User();
		user.setId(26);
		user.setUsername("亚索");
		user.setAge(23);
		user.setPassword("123456");
		user.setSex("男");
		Integer count = mapper.updateUser(user);
		System.out.println(count);
	}
	
	@Test
	@Ignore
	public void test6() {
		// 删除
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		User user = new User();
		user.setId(24);
		Integer count = mapper.deleteUser(user);
		System.out.println(count);
	} 
	
	@Test
	public void test7() {
	    UserMapper mapper = openSession.getMapper(UserMapper.class);
 		// 根据姓名和大概年龄查询
	    String username = "tom";
 		List<Integer> ages = new ArrayList<>();
 		ages.add(21);
 		ages.add(24);
 		
 		List<User> userShow = mapper.getUserByUsernameAndAge(username,ages);
 		System.out.println("根据姓名和大概年龄查询" + userShow);
 		
 	}
	
	@After
	public void after() {
		System.out.println("我是执行后");
		// 提交事务，如果不提交数据库不会产生影响
		openSession.commit();
		openSession.close();
	}

}
