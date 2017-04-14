package com.hjy.oa.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sheeran on 2017/4/12.
 * 分页传输数据的DTO
 */
public class PageBean <T>{
    private int pageNow;
    private int pageCount;
    private int pageSize;
    private int rowCount;
    private int beginPage;
    private int endPage;

    public int getBeginPage() {
        return (pageNow-1)*pageSize;
    }

    public int getEndPage() {
        return pageNow*pageSize;
    }

    private List<T> list=new ArrayList<T>();

    public PageBean() {
    }

    public PageBean(int pageNow, int pageSize) {
        this.pageNow = pageNow;
        this.pageSize = pageSize;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageCount() {
        return (rowCount-1)/pageSize+1;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }


    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
