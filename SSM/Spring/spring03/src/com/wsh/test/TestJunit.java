package com.wsh.test;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wsh.bean.Car;
import com.wsh.bean.CarFactoryBean;
import com.wsh.bean.Student;
import com.wsh.bean.User;
import com.wsh.dao.StudentDao;

public class TestJunit {

	// BeanFactory的基本使用
	@Test
	@Ignore
	public void text01() {
		// 加载XML配置文件
		ClassPathResource resource = new ClassPathResource("ioc.xml");

		// 创建BeanFactory对象
		BeanFactory factory = new XmlBeanFactory(resource);

		// 获取Bean实例
		Student myBean = (Student) factory.getBean("student");

		// 使用Bean实例
		myBean.setId(1);
		myBean.setName("张三");
		System.out.println(myBean);

	}

	// XmlBeanFactory 和 ClassPathXmlApplicationContext 的区别
	@Test
	@Ignore
	public void text02() {
		// XmlBeanFactory只有第一次访问getBean方法才会触发初始化
		XmlBeanFactory xb = new XmlBeanFactory(new ClassPathResource("ioc.xml"));

		// 容器一启动就会触发初始化
//		ClassPathXmlApplicationContext resource = new ClassPathXmlApplicationContext("ioc.xml");

	}

	@Test
	@Ignore
	public void text03() {
		// 创建DefaultListableBeanFactory实例
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		// 到xml文件中读取bean的定义信息
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions(new ClassPathResource("ioc.xml"));
		for (String name : beanFactory.getBeanDefinitionNames()) {
			System.out.println(name);
		}

	}

	@Test
	@Ignore
	public void test04() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");

		// 1.当调用 getBean("car"）时，Spring 通过反射机制发现 CarFactoryBean 实现了 FactoryBean的接口，
		// 这时 Spring 容器就调用接口方法 CarFactoryBean#getObject()方法返回。
		Car car = (Car) context.getBean("car1");
		// 输出：Car{color='红色', maxSpeed='200', price='100'}
		System.out.println(car);

		// 2 .如果希望获取CarFactoryBean 的实例，则需要在使用 getBean(beanName)方法时在 beanName
		// 前显示的加上"＆”前缀，
		// 例如 getBean("&car")。
		CarFactoryBean carFactoryBean = (CarFactoryBean) context.getBean("&car");
		// 输出：com.wsh.bean.CarFactoryBean@491cc5c9
		System.out.println(carFactoryBean.toString());
	}
	
	// 循环依赖
	@Test
	@Ignore
	public void test05() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
		
		StudentDao sd = (StudentDao) context.getBean("studentDao");
		System.out.println(sd);
	}
	
	@Test
	public void test06() {              
             ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
             User user = context.getBean("user",User.class);
             
             System.out.println("6.bean创建完成，可以使用了");
             System.out.println(user);
             
             //销毁方法
             context.close();
	}
	
	

}
