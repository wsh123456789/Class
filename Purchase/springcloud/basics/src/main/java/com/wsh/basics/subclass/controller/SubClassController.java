package com.wsh.basics.subclass.controller;

import com.wsh.basics.subclass.model.*;
import com.wsh.basics.subclass.service.SubClassService;
import com.wsh.basics.util.AllRecordsVo;
import com.wsh.basics.util.POIClass;
import com.wsh.basics.util.ResultBuildVo;
import com.wsh.basics.util.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("subClass")
@CrossOrigin// 跨域
@Api(value = "SubClassController",description = "备件小类")//swagger用在请求的类上，表示对类的说明
public class SubClassController {

    @Autowired
    private SubClassService subClassService;
    @ApiOperation(value="分页查询")//声明接口
    @PostMapping("queryPage")
    public ResultVo<AllRecordsVo<List<SubClassVo>>> queryPage(@RequestBody SubClassSelectVo subClassSelectVo){
        return subClassService.queryPage(subClassSelectVo);
    }
    @ApiOperation(value="新增")//声明接口
    @PostMapping("add")
    public ResultVo add(@RequestBody @Valid SubClassAddVo subClassAddVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return subClassService.add(subClassAddVo);
    }
    @ApiOperation(value="修改")//声明接口
    @PostMapping("update")
    public ResultVo update(@RequestBody @Valid SubClassUpdateVo subClassUpdateVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return subClassService.update(subClassUpdateVo);
    }
    @ApiOperation(value="修改状态")//声明接口
    @PostMapping("updateStatus")
    public ResultVo updateStatus(@RequestBody @Valid SubClassUpdateStatusVo subClassUpdateStatusVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultBuildVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return subClassService.updateStatus(subClassUpdateStatusVo);
    }
    @ApiOperation(value="导入")//声明接口
    @PostMapping("importFile")
    public ResultVo importFile(MultipartFile file) throws IOException {
        if(file == null){
            return ResultBuildVo.error("导入文件不能为空");
        }
        if(!file.getOriginalFilename().contains(".xlsx")){
            System.out.println(file.getOriginalFilename());
            return ResultBuildVo.error("导入文件必须以.xlsx结尾");
        }
        //验证模板
        //读取内容
          Workbook workbook = WorkbookFactory.create(file.getInputStream());
       // XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        //获取单元格中的信息
        Sheet sheet = workbook.getSheetAt(0);
        String stringCellValue = sheet.getRow(0).getCell(0).getStringCellValue();
        if(!stringCellValue.equals("备件小类导入")){
            return ResultBuildVo.error("导入模板错误");
        }
        int lastRowNum = sheet.getLastRowNum();
        if(lastRowNum >= 3000){
            return ResultBuildVo.error("导入数据量过大，请分批导入");
        }
        List<SubClassVo> subClassVoList = new ArrayList<>();
        for (int i = 4;i<=sheet.getLastRowNum();i++){
            String code = sheet.getRow(i).getCell(1).getStringCellValue();
            String name = sheet.getRow(i).getCell(2).getStringCellValue();
            String statusName = sheet.getRow(i).getCell(3).getStringCellValue();
            String remark = sheet.getRow(i).getCell(4).getStringCellValue();
            //sheet.getLastRowNum()有时候会把空的行都进去，在这里做一些判断，为空就跳过
            if(code.isEmpty() && name.isEmpty() && statusName.isEmpty()){
                break;
            }
            SubClassVo subClassVo = new SubClassVo();
            subClassVo.setCode(code);
            subClassVo.setName(name);
            subClassVo.setStatusName(statusName);
            subClassVo.setRemark(remark);
            subClassVoList.add(subClassVo);
        }
        return ResultBuildVo.success(subClassVoList);
    }
    @GetMapping("exportFile")
    public ResultVo exportFile(String name, String code, HttpServletResponse response)throws Exception{
        //1.查询数据库
        List<SubClassVo> subClassVoList = new ArrayList<>();
        SubClassVo subClassVo = new SubClassVo();
        subClassVo.setStatus(true);
        subClassVo.setName("测试名称");
        subClassVo.setCode("测试编码");
        subClassVoList.add(subClassVo);
        if (subClassVoList.size()>5000){
            return ResultBuildVo.error("导出数据量过大，请缩短时间范围！");
        }
        //2.读取模板中的内容
        InputStream in = POIClass.toPackageIn("templates/备件小类导出模板.xlsx");
        //3.向模板中写内容==xssf
        //4.响应给浏览器一个文件

        ServletOutputStream out = response.getOutputStream();
        POIClass.toPackageOs(response, "备件小类导出");
        //把数据写入到模板
        writeDataToExcel(in, "Sheet1", subClassVoList, out);
        if (in != null) {
            in.close();
            out.close();
        }
        return ResultBuildVo.success();
    }

    private void writeDataToExcel(InputStream in, String sheetName, List<SubClassVo> resultList, ServletOutputStream out) throws Exception {
        //POi读取模板
        Workbook wb = WorkbookFactory.create(in);
        //读取sheet1中的数据
        Sheet sheet = wb.getSheet(sheetName);
        if (sheet != null) {
            //向sheet1中赋值，设置样式
            toResultListValueInfo(sheet, resultList);
        }
        //把数据写入到输出流中
        wb.write(out);
        //关闭poi方法
        wb.close();
    }

    private void toResultListValueInfo(Sheet sheet, List<SubClassVo> plantList) {
        //从第4行开始赋值
        int row_column = 3;
        int xuhao =1;
        //遍历数据集合
        for (SubClassVo obj : plantList) {
            //创建一行的方法
            Row row = sheet.createRow(row_column);
            // 给第一列序号赋值赋值
            POIClass.toCellValue(row,0, xuhao + "");
            // 给第二列编码赋值
            POIClass.toCellValue(row, 1, obj.getCode() + "");
            // 给第3列名称赋值
            POIClass.toCellValue(row, 2, obj.getName() + "");
            // 给状态赋值
            POIClass.toCellValue(row, 3, obj.getStatusName() + "");
            //给描述赋值
            POIClass.toCellValue(row, 4, obj.getRemark() + "");
            row_column++;
            xuhao++;
        }
    }

}
