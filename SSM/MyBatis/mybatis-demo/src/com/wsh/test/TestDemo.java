package com.wsh.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.wsh.bean.Book;
import com.wsh.bean.City;
import com.wsh.bean.IdsAndAge;
import com.wsh.bean.Resgion;
import com.wsh.bean.Student;
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
		List<User> user = mapper.getUserByUsernameAndPassword(username, password);
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
	@Ignore
	public void test7() {
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		// 根据姓名和大概年龄查询
		String username = "tom";
		List<Integer> ages = new ArrayList<>();
		ages.add(21);
		ages.add(24);

		List<User> userShow = mapper.getUserByUsernameAndAge(username, ages);
		System.out.println("根据姓名和大概年龄查询" + userShow);

	}

	@Test
	@Ignore
	public void test8() {
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		// 根据姓名和密码查询
		String username = null;
		String password = null;
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		List<User> userShow = mapper.getUserByUsernameAndPassword1(user);
		System.out.println("根据姓名和密码查询" + userShow);

	}

	@Test
	@Ignore
	public void test9() {
		// 修改
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		User user = new User();
		user.setId(28);
		user.setUsername("封魔剑魂-永恩");
		user.setAge(null);
		user.setPassword("123456");
		user.setSex("男");
		Integer count = mapper.updateUserByUser(user);
		System.out.println(count);
	}

	// 批量添加
	@Test
	@Ignore
	public void test10() {

		UserMapper mapper = openSession.getMapper(UserMapper.class);
		List<User> users = new ArrayList<>();
		BufferedReader br = null;
		System.out.println("111");
		try {
			br = new BufferedReader(new FileReader("src/com/wsh/test/userList.txt"));
			String str = null;
			while ((str = br.readLine()) != null) {
				User user = new User();
				String[] message = str.split(",");
				user.setUsername(message[0]);
				user.setPassword(message[1]);
				user.setAge(Integer.parseInt(message[2]));
				user.setSex(message[3]);
				users.add(user);
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer count = mapper.InstertUserList(users);
		System.out.println(count);
	}

	@Test
	@Ignore
	public void test11() {
		UserMapper mapper = (UserMapper) this.openSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("盖伦1");
		user.setPassword("222");
		user.setAge(25);
		user.setSex("男");
		User user2 = new User();
		;
		user2.setUsername("赵信1");
		user2.setPassword("222");
		user2.setAge(25);
		user2.setSex("男");
		User user3 = new User();
		user3.setUsername("嘉文四世1");
		user3.setPassword("222");
		user3.setAge(25);
		user3.setSex("男");
		List<User> userList = new ArrayList();
		userList.add(user);
		userList.add(user2);
		userList.add(user3);
		Integer count = mapper.updateUserList(userList);
		System.out.println(count);
	}

	@Test
	@Ignore
	public void test12() {
		UserMapper mapper = (UserMapper) this.openSession.getMapper(UserMapper.class);
		List<Integer> ids = new ArrayList();
		ids.add(34);
		ids.add(35);
		ids.add(36);
		Integer count = mapper.updateUserByIds(ids, 32);
		System.out.println(count);
	}

	@Test
	@Ignore
	public void test13() {
		UserMapper mapper = (UserMapper) this.openSession.getMapper(UserMapper.class);
		List<Integer> ids = new ArrayList();
		ids.add(34);
		ids.add(35);
		ids.add(36);
		IdsAndAge iaa = new IdsAndAge();
		iaa.setAge(35);
		iaa.setIds(ids);
		Integer count = mapper.updateUserByIaa(iaa);
		System.out.println(count);
	}

	@Test
	@Ignore
	public void test14() {
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		// 1、创建学生信息
		Student stu = new Student();
		stu.setName("张三");
		stu.setAge(20);
		stu.setAddress("齐齐哈尔");
		// 2、创建书本信息
		Book book1 = new Book();
		book1.setBookName("java从入门到放弃");
		book1.setPrice(5.00);

		Book book2 = new Book();
		book2.setBookName("java王者归来");
		book2.setPrice(78.00);

		Book book3 = new Book();
		book3.setBookName("java编程思想");
		book3.setPrice(125.00);

		List<Book> bookList = new ArrayList<>();
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		stu.setBookList(bookList);

		System.out.println(stu);
		// 3、将学生信息添加到数据库中
		mapper.insertStudent(stu);
		openSession.commit();
		// 将学生主键查询出来
		Integer studentId = mapper.getStudentByName("张三");
		System.out.println(studentId);

		// 4、将书本信息添加到数据库
		List<Book> bookList2 = stu.getBookList();
		for (Book book : bookList2) {
			book.setStudentId(studentId);
		}

		mapper.insertBookList(bookList2);
	}

	@Test
	@Ignore
	public void test15() {
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		// 1、创建学生信息
		Student stu = new Student();
		stu.setName("张三");
		stu.setAge(20);
		stu.setAddress("齐齐哈尔");
		// 2、创建书本信息
		Book book1 = new Book();
		book1.setBookName("java从入门到放弃");
		book1.setPrice(5.00);

		Book book2 = new Book();
		book2.setBookName("java王者归来");
		book2.setPrice(78.00);

		Book book3 = new Book();
		book3.setBookName("java编程思想");
		book3.setPrice(125.00);

		List<Book> bookList = new ArrayList<>();
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		stu.setBookList(bookList);

		// 3、将学生信息添加到数据库中
		mapper.insertStudent(stu);
		openSession.commit();

		// 4、将书本信息添加到数据库
		List<Book> bookList2 = stu.getBookList();
		for (Book book : bookList2) {
			book.setStudentId(stu.getId());
		}

		mapper.insertBookList(bookList2);
	}

	@Test
	@Ignore
	public void test16() {
		Student stu = new Student();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		Integer id = mapper.getStudentByName("张三");
		stu.setId(id);
		stu.setName("张三");
		stu.setBookList(mapper.getBooksById(id));
		System.out.println(stu);
	}

	@Test
	@Ignore
	public void test17() {

		UserMapper mapper = openSession.getMapper(UserMapper.class);
		List<Resgion> resgions = new ArrayList<>();

		resgions = mapper.getResgion();
		System.out.println(resgions);
	}

	@Test
	@Ignore
	public void test18() {

		UserMapper mapper = openSession.getMapper(UserMapper.class);
		List<Student> students = new ArrayList<>();
		List<Integer> studentIds = new ArrayList<>();
		students = mapper.getStudent();
		for (Student stu : students) {
			studentIds.add(stu.getId());
		}
		List<Book> books = new ArrayList<>();
		books = mapper.getBookByStuIds(studentIds);
		System.out.println(books);

		for (Student stu : students) {
			List<Book> books1 = new ArrayList<>();
			for (Book book : books) {
				if (book.getStudentId() == stu.getId()) {
					books1.add(book);
				}
			}
			stu.setBookList(books1);
		}

		System.out.println(students);

	}

	@Test
	@Ignore
	public void test19() {

		UserMapper mapper = openSession.getMapper(UserMapper.class);
		List<Student> students = new ArrayList<>();
		students = mapper.getStudents();
		System.out.println(students);

	}

	@Test
	@Ignore
	public void test20() {
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		List<City> cityAll = mapper.getCityAll();
		System.out.println(cityAll);

		// 第一层
		List<City> fristCity = new ArrayList<>();
		for (City city : cityAll) {
			if (city.getParentId() == null) {
				fristCity.add(city);
			}
		}

		for (City city : fristCity) {
			List<City> twoCity = new ArrayList<>();
			// 找第二层
			for (City city2 : cityAll) {
				if (city.getId() == city2.getParentId()) {
					twoCity.add(city2);
				}

			}
			city.setChildList(twoCity);
		}
		// 第一层
		for (City city : fristCity) {
			// 第二层
			for (City city2 : city.getChildList()) {
				// 找第三层
				List<City> threeCity = new ArrayList<>();
				for (City city3 : cityAll) {
					if (city2.getId() == city3.getParentId()) {
						threeCity.add(city3);
					}
				}
				city2.setChildList(threeCity);
			}
		}

		System.out.println(fristCity);
	}

	@Test
	@Ignore
	public void test21() {
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		List<City> cityAll = mapper.getCityAll();
		System.out.println(cityAll);

		// 第一层
		List<City> firstCity = new ArrayList<>();
		for (City city : cityAll) {
			if (city.getParentId() == null) {
				firstCity.add(city);
			}
		}

		for (City city : firstCity) {
			List<City> twoCity = new ArrayList<>();
			// 找第二层
			for (City city2 : cityAll) {
				if (city.getId() == city2.getParentId()) {
					twoCity.add(city2);
				}

			}
			// 在第二层里添加第三层
			for (City city3 : twoCity) {
				List<City> threeCity = new ArrayList<>();
				for (City city4 : cityAll) {
					if (city3.getId() == city4.getParentId()) {
						threeCity.add(city4);
					}
				}
				city3.setChildList(threeCity);
			}
			city.setChildList(twoCity);
		}

	System.out.println(firstCity);

	}


	@After
	public void after() {
		System.out.println("我是执行后");
		// 提交事务，如果不提交数据库不会产生影响
		openSession.commit();
		openSession.close();
	}

}
