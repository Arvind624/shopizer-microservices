package com.shopizer.shipping.model.rules.conditions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Shipping rule conditions population model
 * @author carlsamson
 *
 */
public class Condition implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String storeCode = null;
	private String code = null;
	private String name = null;
	private String format = null;
	private List<String> operators = new ArrayList<String>();
	private String value = null;
	private String defaultValue = null;
	private List<ConditionOption> options = new ArrayList<ConditionOption>();
	
	
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
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public List<String> getOperators() {
		return operators;
	}
	public void setOperators(List<String> operators) {
		this.operators = operators;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public List<ConditionOption> getOptions() {
		return options;
	}
	public void setOptions(List<ConditionOption> options) {
		this.options = options;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

}

