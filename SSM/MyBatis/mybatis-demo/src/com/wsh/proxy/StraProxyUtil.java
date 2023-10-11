package com.wsh.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StraProxyUtil {
	public static Stra createKkProxy(Stra stra){
		Stra straProxy = (Stra)Proxy.newProxyInstance(Stra.class.getClassLoader(), new Class[]{Stra.class},
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object arg0, Method method, Object[] arg2) throws Throwable {
						if(method.getName().equals("sing")){
				            System.out.println("话筒准备完毕！");
				        }else if(method.getName().equals("dance")){
				            System.out.println("背带裤准备完毕！");
				        }else if(method.getName().equals("play")){
				            System.out.println("蓝球准备完毕！");
				        }
						System.out.println("=====" + method.getName());
				        Object result = method.invoke(stra, arg2);

				        return result;
					}
				});
		
		return straProxy;
	}
}
