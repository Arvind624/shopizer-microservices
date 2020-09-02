package com.shopizer.shipping.model.rules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;

public class BaseCondition implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "FIELD")
	private String field = null;
	@Column(name = "OPERATOR")
    private String operator = null;
	@Column(name = "ENTITY")
    private String entity = null; //might be removed
	
	@ElementCollection
	@CollectionTable(name = "VALUE")
    private List<String> value = new ArrayList<String>();
    
    
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public List<String> getValue() {
		return value;
	}
	public void setValue(List<String> value) {
		this.value = value;
	}


}
