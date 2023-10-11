package com.wsh.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wsh.bean.Book;
import com.wsh.bean.City;
import com.wsh.bean.IdsAndAge;
import com.wsh.bean.Resgion;
import com.wsh.bean.Student;
import com.wsh.bean.User;

public interface UserMapper {

	List<User> getUserAll();

	List<User> getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

	List<User> getUserByUser(User user1);

	List<User> getUserByList(HashMap<String, String> hash);

	Integer addUser(User user);

	Integer updateUser(User user);

	Integer deleteUser(User user);

	List<User> getUserByUsernameAndAge(@Param("username") String username, @Param("ages") List<Integer> ages);

	List<User> getUserByUsernameAndPassword1(User user);

	Integer updateUserByUser(User user);

	Integer InstertUserList(@Param("users") List<User> users);

	Integer updateUserList(@Param("userList") List<User> userList);

	Integer updateUserByIds(@Param("userList") List<Integer> ids, @Param("age") int age);

	Integer updateUserByIaa(IdsAndAge iaa);

	void insertStudent(Student stu);

	Integer getStudentByName(String name);

	void insertBookList(@Param("bookList") List<Book> bookList2);

	List<Book> getBooksById(@Param("id")int studentId);

	List<Resgion> getResgion();

	List<Student> getStudent();

	List<Book> getBookByStuIds(@Param("studentIds")List<Integer> studentIds);

	List<Student> getStudents();

	List<City> getCityAll();

}
