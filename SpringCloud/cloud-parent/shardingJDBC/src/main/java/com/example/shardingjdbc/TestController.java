package com.example.shardingjdbc;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class TestController {
    @Autowired
    private TestMapper testMapper;

    @GetMapping("query")
    public List<UserVo> query(){
        return testMapper.queryList();
    }

    @GetMapping("add")
    public int add(){
        UserVo userVo = new UserVo();
        userVo.setName("张亮");
        return testMapper.insertUser(userVo);
    }
    @GetMapping("add2")
    public void add2(){
        for (int i = 1; i <11 ; i++) {
         CustomerVo customerVo = new CustomerVo();
            customerVo.setId(i);
            customerVo.setUid(i);
            customerVo.setName("测试名称");
            int i1 = RandomUtils.nextInt();
            customerVo.setAge(i1);
            customerVo.setAddress("测试地址！！");
            testMapper.insertCustomer(customerVo);
        }

    }
    @GetMapping("query2")
    public List<CustomerVo> query2(){
        return testMapper.queryCustomer();
    }

    public static void main(String[] args) {
        int i1 = RandomUtils.nextInt();
        System.out.println(i1);
    }
}
