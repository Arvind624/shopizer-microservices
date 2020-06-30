package com.shopizer.catalog.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main class
 * @author carlsamson
 *
 */
@RestController
public class CatalogApi {
	
	@GetMapping("/")
	public String test() {
		return "This is catalog api";
	}
	
	
	/**
	 * Test config server
	 * @author carlsamson
	 *
	 */

	 @RefreshScope 
	 @RestController class MessageRestController { 
	 @Value("${message:Default message}") private String message; 
	 @RequestMapping("/message") String getMessage() { return this.message; } }
	 

}
