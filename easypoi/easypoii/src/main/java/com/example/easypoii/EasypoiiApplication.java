package com.example.easypoii;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.example.easypoii.moudel.Card;
import com.example.easypoii.moudel.Orders;
import com.example.easypoii.moudel.User;
import com.example.easypoii.moudel.Useremps;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class EasypoiiApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EasypoiiApplication.class, args);
//        //获取数据
//        List<User> user = getList();
        //导出
//        exprot(user);
        //大数据量的导出
//        bigNum(user);
        //导入
        testImport();
    }

    //获取数据
    public static List<User> getList(){
        List<User> userList = new ArrayList<>();
        for (int i =0 ;i<=5;i++){
            User user = new User();
            user.setId(String.valueOf(i));
            user.setName("小陈");
            user.setAge(10+i);
            user.setBir(new Date());
            Card card = new Card();
            card.setCardNum("142423123456781234");
            card.setAddress("北京市顺义区泥河村");
            user.setCard(card);

            List<Orders> ordersList = new ArrayList<>();
            ordersList.add(new Orders("001","笔记本"));
            ordersList.add(new Orders("002","鼠标"));
            ordersList.add(new Orders("003","键盘"));
            user.setOrdersList(ordersList);
//            绝对路径
            user.setPhoto("C:/Users/Lenovo/Desktop/geshou.jpg");
            if(i%2==0){
                user.setStatus(0);
                user.setHabbys(Arrays.asList("唱歌", "跳舞", "打篮球"));
            }else{
                user.setStatus(1);
                user.setHabbys(Arrays.asList("键盘", "下棋", "品茗"));
            }
            userList.add(user);
        }
        return userList;
    }
    public static void exprot(List<User> user)throws Exception{
        //导出excel
        //参数1:exportParame 导出配置对象 参数2：导出的类型 参数3：导出数据集合
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息列表", "用户信息"), User.class, user);
        //将数据写入指定位置的excel
        FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/Lenovo/Desktop/导出2.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
    }
    //大数据导出
    public static void bigNum(List<User> user)throws Exception{
        //exportBigExcel 专门处理大数据
        Workbook workbook = ExcelExportUtil.exportBigExcel(new ExportParams("用户信息列表", "用户信息"), User.class, user);
        //从指定位置的excel中读取数据
        FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/Lenovo/Desktop/big.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
    }
    //普通数据导入
    public static void testImport()throws Exception{
        //创建导入对象
        ImportParams params = new ImportParams();
        //标题占的行数
        params.setTitleRows(1);
        //header列占几行
        params.setHeadRows(1);

//        params.setStartSheetIndex(0); //从第几个Sheet开始读
//        params.setSheetNum(2);
        //校验导入的实体类 有没有这个属性
//        params.setImportFields(new String[]{"编号"});

        //参数1：导入excel文件流 参数2：导入类型 参数3：导入的配置对象
        List<Useremps> useremps = ExcelImportUtil.importExcel(new FileInputStream("C:/Users/Lenovo/Desktop/easypoi导入.xls"), Useremps.class, params);
        for (Useremps useremps1:useremps) {
            System.out.println(useremps1);
        }
    }

}
