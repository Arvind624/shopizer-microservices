package com.shopizer.shipping.model.rules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.shopizer.shipping.api.utils.Constants;

@Entity
@Table(name="RULE", schema=Constants.SHIPPING_SCHEMA)
public class Rule implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * rule meta data
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "RULE_ID", unique=true, nullable=false)
	private Long id;
	@Column(name = "CODE", nullable=false)
	private String code;
	@Column(name = "NAME")
	private String name;
	@Column(name = "TIME_BASED")
	private boolean timeBased;
	@Column(name = "START_DATE")
	private String startDate;
	@Column(name = "END_DATE")
	private String endDate;
	@Column(name = "ACTIVE")
	private boolean active;
	@Column(name = "POSITION")
	private int order;
	@Column(name = "STORE", nullable=false)
	private String store;
	

	/**
	 * conditions
	 */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="rule")
	private List<InputCondition> conditions = new ArrayList<InputCondition>();
	
	
	/**
	 * results
	 */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="rule")
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


	public List<InputCondition> getConditions() {
		return conditions;
	}


	public void setConditions(List<InputCondition> conditions) {
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


	public String getStore() {
		return store;
	}


	public void setStore(String store) {
		this.store = store;
	}

}
