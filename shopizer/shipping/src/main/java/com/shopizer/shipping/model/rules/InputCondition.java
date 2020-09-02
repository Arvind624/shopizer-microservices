package com.shopizer.shipping.model.rules;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopizer.shipping.api.utils.Constants;

@Entity
@Table(name="CONDITION", schema=Constants.SHIPPING_SCHEMA)
public class InputCondition extends BaseCondition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CONDITION_ID", unique=true, nullable=false)
	private Long id;
	
	@Column(name = "CONDITION")
	private String condition = null;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="RULE_ID", nullable=false)
	private Rule rule;
	
	@OneToMany(mappedBy="condition")
	private List<InputCondition> rules;
	
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public List<InputCondition> getRules() {
		return rules;
	}
	public void setRules(List<InputCondition> rules) {
		this.rules = rules;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Rule getRule() {
		return rule;
	}
	public void setRule(Rule rule) {
		this.rule = rule;
	}


}
