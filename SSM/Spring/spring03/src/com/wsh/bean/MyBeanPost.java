package com.wsh.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//后置处理器
public class MyBeanPost implements BeanPostProcessor {   
      /**
       * @param bean : 指的是bean里面输出的值
       * @param beanName : 指的是配置文件中的 <bean id />值
       */
      // 初始化之前执行
      @Override
      public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
              System.out.println("3.后置处理器，初始化之前执行");
              System.out.println(beanName + "::" + bean);
              return bean;
      }
      
      // 初始化之后输出
      @Override
      public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
              System.out.println("5.后置处理器，初始化之后执行");
              System.out.println(beanName + "::" + bean);
              return bean;
      }
     
}
