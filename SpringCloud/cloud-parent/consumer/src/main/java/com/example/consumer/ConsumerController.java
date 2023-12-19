package com.example.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@DefaultProperties(defaultFallback = "morenJiangJi")
public class ConsumerController {
    @GetMapping("testConsumer")
    public String testConsumer() throws Exception {
        // 1 获取httpClient客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "http://localhost:7010/testProvider";
        // 2 创建请求
        HttpGet httpGet = new HttpGet(url);
        // 3 发送请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        // 4 响应状态码 响应信息
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        // 响应信息
        HttpEntity entity = httpResponse.getEntity();
        String s = EntityUtils.toString(entity);
        httpResponse.close();
        httpClient.close();
        return s;
    }

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("testConsumer2")
    public String testConsumer2() throws Exception {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + getServer() + "/testProvider", String.class);
        return forEntity.getBody();
    }

    private static final List<String> servers = Arrays.asList("7010","7011");
    public static String getServer(){
        Random random = new Random();
        int index = random.nextInt(servers.size());
        return servers.get(index);
    }

    @GetMapping("testConsumer3")
    public String testConsumer3() throws Exception {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://provider/testProvider", String.class);
        return forEntity.getBody();
    }

    @GetMapping("testConsumer4")
    public String testConsumer4() throws Exception {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:"+ RegistrationCenter.getService() +"/testProvider", String.class);
        return forEntity.getBody();
    }

    @GetMapping("testConsumer5")
    public UserVo testConsumer5() throws Exception {
        UserVo userVo = new UserVo();
        userVo.setId(1);
        userVo.setName("张三");
        UserVo userVo1 = restTemplate.postForObject("http://localhost:7011/testProviderPost", userVo, UserVo.class);
        return userVo1;
    }

    @GetMapping("testConsumer6")
    @HystrixCommand(fallbackMethod = "jiangji")
    public String testConsumer6() throws Exception {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://provider/testProvider2", String.class);
        System.out.println(forEntity.getBody());
        return forEntity.getBody();
//        throw  new Exception();
    }

    @GetMapping("testConsumer7")
    @HystrixCommand
    public String testConsumer7() throws Exception {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://provider/testProvider2", String.class);
        System.out.println(forEntity.getBody());
        return forEntity.getBody();
//        throw  new Exception();
    }

    public String jiangji()throws Exception{
        return "当前服务访问人数过多，请稍后重试！！！";
    }
    public String morenJiangJi()throws Exception{
        return "当前网络开小差了，请刷新后重试！！！";
    }

    @GetMapping("testR")
    @HystrixCommand
    public String rongduan(Integer count)throws Exception{
        if(count==1){
            return "请求成功！！";
        }else {
            throw new Exception();
        }
    }

}
