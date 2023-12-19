package com.example.inventory.util;

public class  PageVo {
    private Integer pageIndex;//当前页
    private Integer pageSize;//每页大小
    private Integer offset;//索引


    public Integer getPageIndex() {
        return pageIndex;
    }
    public void setPageIndex(Integer pageIndex) {
        if(pageIndex==null||pageIndex==0){
            this.pageIndex = 1;
        }else{
            this.pageIndex=pageIndex;
        }

    }
    public Integer getPageSize() {
        return pageSize;
    }
    //自动计算索引
    public void setPageSize(Integer pageSize) {
        if(pageSize==null||pageSize==0){
            this.pageSize = 10;
        }else{
            this.pageSize = pageSize;
        }
        //计算索引
        Integer suoyin = (pageIndex-1)*this.pageSize;
        this.offset = suoyin;
    }
    public Integer getOffset() {
        return offset;
    }


}

