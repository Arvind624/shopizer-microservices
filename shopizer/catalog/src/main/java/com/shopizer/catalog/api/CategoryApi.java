package com.shopizer.catalog.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryApi {
	

	
	

	
	
	@GetMapping("/category")
	public String list() {
		return "List of category";
	}

}
