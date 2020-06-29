package com.shopizer.catalog.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductApi {
	

	@GetMapping("/product")
	public String list() {
		return "Product details";
	}

}
