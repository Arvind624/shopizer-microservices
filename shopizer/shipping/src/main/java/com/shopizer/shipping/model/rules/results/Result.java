package com.shopizer.shipping.model.rules.results;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Result implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String storeCode = null;
	private String code = null;
	private String name = null;
	private String format = null;
	private String value = null;
	private String defaultValue = null;
	private List<ResultOption> selectOptions = new ArrayList<ResultOption>();
	
	
	public String getStoreCode() {
		
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
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
	public List<ResultOption> getSelectOptions() {
		return selectOptions;
	}
	public void setSelectOptions(List<ResultOption> selectOptions) {
		this.selectOptions = selectOptions;
	}

}
