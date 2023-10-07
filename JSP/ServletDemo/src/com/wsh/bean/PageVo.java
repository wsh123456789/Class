package com.wsh.bean;

import java.util.List;

public class PageVo<T> {

    // 当前页
    private int currentPage;
    /// 总条数
    private int totalNum;
    // 总页数
    private  int totalPage;
    // 查询数据
    private List<T> userList;

    // 每页多少数据
    private Integer pageCount;
    public PageVo() {
    }

    public PageVo(int currentPage, int totalNum, int totalPage, List<T> userList, Integer pageCount) {
        this.currentPage = currentPage;
        this.totalNum = totalNum;
        this.totalPage = totalPage;
        this.userList = userList;
        this.pageCount = pageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }


    public List<T> getUserList() {
        return userList;
    }

    public void setUserList(List<T> userList) {
        this.userList = userList;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "PageVo{" +
                "currentPage=" + currentPage +
                ", totalNum=" + totalNum +
                ", totalPage=" + totalPage +
                ", userList=" + userList +
                '}';
    }


}
