package com.example.consumer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

//@Component
public class TimerTask {
//    @Scheduled(cron = "0/3 * * * * ? ")
    public void test() {
        System.out.println("我是注解的定时器");
        Map<String, List<ServerVo>> serverMap = new HashMap<>();
        List<ServerVo> serverList = new ArrayList<>();
        serverList.add(new ServerVo("7010",true,new Date().getTime()));
        serverList.add(new ServerVo("7011",true,new Date().getTime()));
        serverMap.put("testProvider",serverList);
        System.out.println(serverMap);
    }


}
