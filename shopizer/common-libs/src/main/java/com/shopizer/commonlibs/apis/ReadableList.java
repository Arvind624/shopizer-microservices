package com.shopizer.commonlibs.apis;

import java.io.Serializable;
import java.util.List;

public class ReadableList<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int totalPages;//totalPages
	private int number;//number of record in current page
	private long recordsTotal;//total number of records in db
	private int recordsFiltered;
	private List<T> list;//list of entity

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalCount) {
		this.totalPages = totalCount;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
