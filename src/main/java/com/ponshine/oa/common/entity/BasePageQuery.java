package com.ponshine.oa.common.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author liuhui
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @date
 */

public class BasePageQuery<T> {

    /**
     * 当前页数
     */
    @JSONField(name="pageNumber")
    private int pageNumber = 1;
    /**
     * 每页显示的个数
     */
    private int pageSize = 10;
    /**
     * 总记录数
     */
    private long total;
    /**
     * 查询起
     */
    private int start;
    /**
     * 查询止
     */
    private int end;
    /**
     * 分页查询的结果
     */
    private List<T> rows;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getStart() {
        return start <= 0 ? (pageNumber - 1) * pageSize : start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end <= 0 ? pageNumber  * pageSize : start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}

