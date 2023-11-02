package com.wsh.point;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//切面类
@Component
@Aspect
public class PointProxy {

	//前置通知
//	@Before("execution(public * com.wsh.service.TestServiceImpl.*(int,int))")
	public void before(JoinPoint jp){
		//日志记录
		//流量统计
		//获取参数
		Object[] args = jp.getArgs();
		System.out.println(Arrays.toString(args));
		Signature signature = jp.getSignature();
		//获取方法名称
		String name = signature.getName();
		System.out.println(name);
		System.out.println("我是前置通知");
	}
	
	//后置通知
//	@After("execution(public * com.wsh.service.TestServiceImpl.*(int,int))")
	public void after(JoinPoint jp){
		//日志记录
		//流量统计
		//获取参数
		Object[] args = jp.getArgs();
		System.out.println(Arrays.toString(args));
		Signature signature = jp.getSignature();
		//获取方法名称
		String name = signature.getName();
		System.out.println(name);
		System.out.println("我是后置通知");
		
	}
	
	//环绕通知
	@Around("execution(public * com.wsh.service.TestServiceImpl.*(int,int))")
	public void around(ProceedingJoinPoint jpj) throws Throwable{
		//日志记录
		//流量统计
		//获取参数
		Object[] args = jpj.getArgs();
		System.out.println(Arrays.toString(args));
		Signature signature = jpj.getSignature();
		//获取方法名称
		String name = signature.getName();
		System.out.println(name);
		System.out.println("方法触发前的通知");
		//日志记录
		Object object = jpj.proceed();
		System.out.println("方法触发后的通知");
		//流量统计
	}
}
