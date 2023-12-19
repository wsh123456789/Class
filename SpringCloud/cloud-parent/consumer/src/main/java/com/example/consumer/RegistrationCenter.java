package com.example.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
public class RegistrationCenter {
    static Map<String, List<ServerVo>> serverMap = new HashMap<>();

    // 模拟注册中心已经注册过的服务地址
    static {
        List<ServerVo> serverList = new ArrayList<>();
        serverList.add(new ServerVo("7010", true, 0));
        serverList.add(new ServerVo("7011", true, 0));
        serverMap.put("testProvider", serverList);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(cron = "0/30 * * * * ?")
    public void heart() {
        String interfaceName = "testProvider";
        for (ServerVo server : serverMap.get(interfaceName)) {
            // 获取当前时间作为接口调用的初始时间
            long startTime = System.currentTimeMillis();
            // 访问接口
            // 如果报错就设置为禁用状态
            try {
                ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + server.getIp() + "/testProvider", String.class);
                server.setStatus(true);
            }catch (Exception e){
                server.setStatus(false);
            }

            // 获取当前时间作为接口调用的结束时间
            long endTime = System.currentTimeMillis();
            // 如果接口响应信息不为空说明响应成功进行比对响应时间
            if (server.getStatus()) {
                server.setTime(endTime - startTime);
            }
//            System.out.println(server);
        }
    }

    public static String getService() {
//        System.out.println(serverMap);
        String interfaceName = "testProvider";
        // 设置一个足够大的数字保证第一个响应时间能正常赋值
        long currentTime = 0x7fffffff;
        // 存储权重最高的端口
        String chosen = null;
        // 遍历列表寻找权重最大的(响应时间最快的)
        for (ServerVo server : serverMap.get(interfaceName)) {
            // 判断是否是启用状态，如果是就进行调用
            if (server.getStatus()) {
                // 寻找最小运行时间
                if (server.getTime() <= currentTime) {
                    currentTime = server.getTime();
                    chosen = server.getIp();
                }
            }
        }
//        System.out.println(chosen);
        return chosen;
    }
}
