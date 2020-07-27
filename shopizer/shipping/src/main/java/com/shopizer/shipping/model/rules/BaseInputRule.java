package com.shopizer.shipping.model.rules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseInputRule implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String field = null;
    private String operator = null;
    private String entity = null; //might be removed
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
