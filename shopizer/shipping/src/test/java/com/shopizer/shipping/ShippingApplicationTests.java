package com.shopizer.shipping;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopizer.shipping.model.rules.InputResult;
import com.shopizer.shipping.model.rules.InputCondition;
import com.shopizer.shipping.model.rules.Rule;

@SpringBootTest
class ShippingApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void createRule() {
		Rule rule = new Rule();
		rule.setActive(true);
		rule.setCode("test");
		rule.setName("Shipping decision summer 2020");
		rule.setTimeBased(true);
		rule.setStartDate("2020-07-15");
		rule.setEndDate("2020-10-15");
		
		
		//conditions
		
		
		List<InputCondition> conditions = new ArrayList<InputCondition>();
		
		//base condition
		InputCondition ir = new InputCondition();
		ir.setCondition("and");
		
		//individual conditions
		List<InputCondition> individuals = new ArrayList<InputCondition>();
		
		InputCondition  shippingCountry = new InputCondition();
		shippingCountry.setField("shippingCountry");
		shippingCountry.setOperator("in");
		
		List<String> value = new ArrayList<String>();
		value.add("CA");
		value.add("US");
		shippingCountry.setValue(value);
		
		individuals.add(shippingCountry);
		
		InputCondition  orderTotal = new InputCondition();
		orderTotal.setField("orderTotal");
		orderTotal.setOperator("=");
		
		List<String> otvalue = new ArrayList<String>();
		otvalue.add("100");

		orderTotal.setValue(otvalue);
		
		individuals.add(orderTotal);
		
		ir.setRules(individuals);
		conditions.add(ir);
		
		//results - free shipping shipping fedex
		List<InputResult> results = new ArrayList<InputResult>();
		InputResult r1 = new InputResult();
		r1.setCode("free");
		r1.setValue("true");
		
		results.add(r1);
		
		InputResult r2 = new InputResult();
		r2.setCode("shippingMethod");
		r2.setValue("fedex");
		
		results.add(r2);
		
		rule.setConditions(conditions);
		rule.setResults(results);
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String ruleAsString = objectMapper.writeValueAsString(rule);
			System.out.println(ruleAsString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
