package com.shopizer.shipping.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.shopizer.shipping.model.rules.FieldFormatEnum;
import com.shopizer.shipping.model.rules.InputCondition;
import com.shopizer.shipping.model.rules.InputResult;
import com.shopizer.shipping.model.rules.Rule;
import com.shopizer.shipping.model.rules.conditions.Condition;
import com.shopizer.shipping.model.rules.conditions.ConditionOption;
import com.shopizer.shipping.model.rules.conditions.OperatorConstants;
import com.shopizer.shipping.model.rules.results.Result;
import com.shopizer.shipping.model.rules.results.ResultOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class ShippingConfig {
	
	
	private static final Logger log = LoggerFactory.getLogger(ShippingConfig.class);
	
	
	private static final List<String> operators_in = new ArrayList<String>(Arrays. asList(OperatorConstants.IN,OperatorConstants.NOT));
	private static final List<String> operators_numeric = new ArrayList<String>(Arrays. asList(OperatorConstants.EQUAL,OperatorConstants.GREATER_THAN_EQUAL,OperatorConstants.GREATER_THAN));
	
	/*
	 * @Bean
	 * 
	 * @Profile("!prod") public GroupedOpenApi actuatorApi() { return
	 * GroupedOpenApi.builder().group("Actuator").pathsToMatch("/actuator/**")
	 * .pathsToExclude("/actuator/health/*").build(); }
	 */
	
	

	/*
	 * @Bean public OpenAPI customOpenAPI(@Value("${application-description}")
	 * String appDesciption,
	 * 
	 * @Value("${application-version}") String appVersion) { return new OpenAPI()
	 * .info(new Info() .title("sample application API") .version(appVersion)
	 * .description(appDesciption) .termsOfService("http://swagger.io/terms/")
	 * .license(new License().name("Apache 2.0").url("http://springdoc.org"))); }
	 */
	
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
	

	
	@Bean
	public List<Condition> defaultConditions() {
		log.debug("default conditions");
		
		List<Condition> conditions = new ArrayList<Condition>();
		
		Condition c1 = new Condition();
		c1.setCode("sku");
		c1.setName("Order contains product code");
		c1.setFormat(FieldFormatEnum.STRING.name());
		c1.setOperators(operators_in);
		c1.setDefaultValue("ABCXYZ100");
		conditions.add(c1);
		
		Condition c2 = new Condition();
		c2.setCode("categoryCode");
		c2.setName("Order contains category code");
		c2.setFormat(FieldFormatEnum.STRING.name());
		c2.setOperators(operators_in);
		conditions.add(c2);
		
		Condition c3 = new Condition();
		c3.setCode("quantity");
		c3.setName("Quantity of items in order");
		c3.setValue("1");
		c3.setFormat(FieldFormatEnum.NUMERIC.name());
		c3.setOperators(operators_numeric);
		conditions.add(c3);
		
		Condition c4 = new Condition();
		c4.setCode("shippingProvince");
		c4.setName("Delivery province");
		c4.setFormat(FieldFormatEnum.STRING.name());
		c4.setOperators(new ArrayList(Arrays.asList(OperatorConstants.IN)));
		conditions.add(c4);
		
		Condition c7 = new Condition();
		c7.setCode("shippingDistance");
		c7.setName("Shipping distance");
		c7.setFormat(FieldFormatEnum.NUMERIC.name());
		c7.setOperators(operators_numeric);
		conditions.add(c7);
		
		Condition c5 = new Condition();
		c5.setCode("orderTotal");
		c5.setName("Order total");
		c5.setFormat(FieldFormatEnum.DECIMAL.name());
		c5.setOperators(new ArrayList(Arrays.asList(OperatorConstants.EQUAL,OperatorConstants.GREATER_THAN_EQUAL, OperatorConstants.GREATER_THAN)));
		conditions.add(c5);
		
		Condition c6 = new Condition();
		c6.setCode("shippingCountry");
		c6.setName("Delivery country");
		c6.setFormat(FieldFormatEnum.STRING.name());
		c6.setOperators(new ArrayList(Arrays.asList(OperatorConstants.EQUAL,OperatorConstants.IN)));
		
		ConditionOption c6o = new ConditionOption();
		c6o.setCode("CA");
		c6o.setName("Canada");
		c6o.setValue("CA");
		
		ConditionOption c6o1 = new ConditionOption();
		c6o1.setCode("US");
		c6o1.setName("United states");
		c6o1.setValue("US");
		
		c6.getOptions().add(c6o);
		c6.getOptions().add(c6o1);
		
		conditions.add(c6);
		
		
		return conditions;
	}
	
	@Bean
	public List<Result> defaultResults() {
		
		log.debug("default results");
		
		List<Result> results = new ArrayList<Result>();
		
		Result r1 = new Result();
		r1.setCode("handlingFee");
		r1.setName("Handling fees");
		r1.setFormat(FieldFormatEnum.DECIMAL.name());
		r1.setDefaultValue("0.00");
		results.add(r1);
		
		Result r2 = new Result();
		r2.setCode("free");
		r2.setName("Free shipping");
		r2.setFormat(FieldFormatEnum.BOOLEAN.name());
		r2.setValue("false");
		results.add(r2);
		
		Result r3 = new Result();
		r3.setCode("shippingFee");
		r3.setName("Shipping fees");
		r3.setFormat(FieldFormatEnum.DECIMAL.name());
		results.add(r3);
		
		Result r4 = new Result();
		r4.setCode("shippingMethod");
		r4.setName("Shipping method");
		r4.setFormat(FieldFormatEnum.STRING.name());
		
		ResultOption r4option = new ResultOption();
		r4option.setCode("canadapost");
		r4option.setName("Canada Post");
		r4option.setValue("canadapost");
		r4.getSelectOptions().add(r4option);
		
		ResultOption r4option1 = new ResultOption();
		r4option1.setCode("fedex");
		r4option1.setName("Fedex");
		r4option1.setValue("fedex");
		r4.getSelectOptions().add(r4option1);
		
		ResultOption r4option2 = new ResultOption();
		r4option2.setCode("ups");
		r4option2.setName("UPS");
		r4option2.setValue("ups");
		r4.getSelectOptions().add(r4option2);
		
		ResultOption r4option3 = new ResultOption();
		r4option3.setCode("usps");
		r4option3.setName("USPS");
		r4option3.setValue("usps");
		r4.getSelectOptions().add(r4option3);
		
		
		results.add(r4);
		
		return results;
	}
	
	@Bean
	public List<Rule> defaultRules() {
		
		
		log.debug("default rules");
		
		List<Rule> allRules = new ArrayList<Rule>();
		Rule rule = new Rule();
		rule.setActive(true);
		rule.setOrder(1);
		rule.setId(-1L);
		rule.setCode("test");
		rule.setName("Shipping decision summer 2020");
		rule.setStore("DEFAULT");
		rule.setTimeBased(true);
		rule.setStartDate("2020-07-15");
		rule.setEndDate("2020-10-15");
		
		allRules.add(rule);
		
		
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
		orderTotal.setOperator(">");
		
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
		
		
		return allRules;

	}

}
