package com.ponshine.oa.common.dto;

/**
 * 封装查询相关字段
 */
public class PageVO {
	@Override
	public String toString() {
		return "PageVO [page=" + page + ", rows=" + rows + ", sort=" + sort
				+ ", order=" + order + "]";
	}

	private int page;// 当前页码
	private int rows;// 每页条数
	private String sort;// 排序字段
	private String order;// 排序方式
	/**
	 * 
	 * @Description: TODO
	 * @param page	分页
	 * @param rows	分页参数
	 * @param sort	分页参数
	 * @param order	工单
	 */
	public PageVO(int page, int rows, String sort, String order){
		this.page = page;
		this.rows = rows;
		this.sort = sort;
		this.order = order;
	};
	/**
	 * 
	 * @Description: TODO
	 */
	public PageVO(){};

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
}
