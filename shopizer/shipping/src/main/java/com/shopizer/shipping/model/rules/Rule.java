package com.shopizer.shipping.model.rules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Rule implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * rule meta data
	 */
	private Long id;
	private String code;
	private String name;
	private boolean timeBased;
	private String startDate;
	private String endDate;
	private boolean active;
	private int order;
	

	/**
	 * conditions
	 */
	private List<InputRule> conditions = new ArrayList<InputRule>();
	
	
	/**
	 * results
	 */
	private List<InputResult> results = new ArrayList<InputResult>();


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isTimeBased() {
		return timeBased;
	}


	public void setTimeBased(boolean timeBased) {
		this.timeBased = timeBased;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public int getOrder() {
		return order;
	}


	public void setOrder(int order) {
		this.order = order;
	}


	public List<InputRule> getConditions() {
		return conditions;
	}


	public void setConditions(List<InputRule> conditions) {
		this.conditions = conditions;
	}


	public List<InputResult> getResults() {
		return results;
	}


	public void setResults(List<InputResult> results) {
		this.results = results;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

}
