package com.lyy.web.util;


import com.lyy.web.entity.Teacher;

import java.util.List;

public class PageInfo {
    // 当前页的数据
    private List<Teacher> list;
    // 一共有多少页
    private Integer totalPage;
    // 当前是第几页
    private Integer pageNo;
    // 每页有多少条数据
    private Integer pageSize;

    public PageInfo() {
    }

    public PageInfo(List<Teacher> list, Integer totalPage, Integer pageNo, Integer pageSize) {
        this.list = list;
        this.totalPage = totalPage;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public List<Teacher> getList() {
        return list;
    }

    public void setList(List<Teacher> list) {
        this.list = list;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "list=" + list +
                ", totalPage=" + totalPage +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }

//    public static void main(String[] args) {
//        int totalCount = 12;
//        int pageSize = 5;
//        int totalPage = (int)Math.ceil((double)totalCount / pageSize);
//        System.out.println(totalPage);// 2
//    }
}
