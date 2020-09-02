package com.shopizer.shipping.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shopizer.shipping.model.rules.Rule;

public interface RuleRepository extends CrudRepository<Rule, Long> {
	
	
	List<Rule> findByStore(String store);

}
