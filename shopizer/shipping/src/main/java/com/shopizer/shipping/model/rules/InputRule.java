package com.shopizer.shipping.model.rules;

import java.io.Serializable;
import java.util.List;

public class InputRule extends BaseInputRule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String condition = null;
	private List<InputRule> rules;
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public List<InputRule> getRules() {
		return rules;
	}
	public void setRules(List<InputRule> rules) {
		this.rules = rules;
	}


}
