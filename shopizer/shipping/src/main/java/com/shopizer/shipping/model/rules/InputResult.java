package com.shopizer.shipping.model.rules;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopizer.shipping.api.utils.Constants;

@Entity
@Table(name="RESULT", schema=Constants.SHIPPING_SCHEMA)
public class InputResult implements Serializable {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "RESULT_ID", unique=true, nullable=false)
	private Long id;
	
	@Column(name = "CODE", nullable=false)
	private String code;
	
	@Column(name = "VALUE", nullable=false)
	private String value;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="RULE_ID", nullable=false)
	private Rule rule;
	
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
