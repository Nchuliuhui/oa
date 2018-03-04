package com.ponshine.oa.common.dto;

import java.util.List;


/**
 * This is a pagination DTO
 * @author sinba
 */
public class PageDTO<T> {

    private static final int DEFAULT_ROW_PAGE = 10;
    private static final int DEFAULT_CUURRENT_PAGE = 1;
    private int total; //总记录数
    @SuppressWarnings("rawtypes")
	private List<T> rows; //需要显示的数据
    private int currPage = DEFAULT_CUURRENT_PAGE; //当前页数
    private int pageSize = DEFAULT_ROW_PAGE; //每页显示的数量
    private int totalPage; //总的页数
    /**
     * 
     * @Description: TODO
     */
    public PageDTO(){}

    public PageDTO(int currPage, int pageSize) {
        this.currPage = currPage;
        this.pageSize = pageSize;
    }

    public PageDTO(int currPage) {
        this.currPage = currPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}