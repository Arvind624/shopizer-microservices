package com.shopizer.shipping.api;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shopizer.shipping.api.utils.Constants;
import com.shopizer.shipping.model.rules.conditions.Condition;
import com.shopizer.shipping.model.rules.results.Result;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = Constants.API_VERSION)
@Tag(name = "shipping", description = "Shipping rules API")
public class ShippingRulesApi {
	
	
	@Autowired
	private List<Condition> defaultConditions;
	
	@Autowired
	private List<Result> defaultResults;
	

    //@Operation(summary = "List list of defined conditions", description = "List of predefined conditions", tags = { "shipping conditions" })
    //@ApiResponses(value = {
    //    @ApiResponse(responseCode = "200", description = "successful operation", 
    //            content = @Content(array = @ArraySchema(schema = @Schema(implementation = List.class)))) })	
    @GetMapping(value = "/shipping/rules/conditions", produces = { "application/json" })
    @ResponseStatus(code = HttpStatus.OK)
	public List<Condition> conditions() {
    	

    	List<Condition> ordered = defaultConditions.stream()
    			.sorted(Comparator.comparing(Condition::getName))
    			.collect(Collectors.toList());
    	
		return ordered;
	}
    
    @GetMapping(value = "/shipping/rules/results", produces = { "application/json" })
    @ResponseStatus(code = HttpStatus.OK)
	public List<Result> results() {
    	

    	List<Result> ordered = defaultResults.stream()
    			.sorted(Comparator.comparing(Result::getName))
    			.collect(Collectors.toList());
    	
		return ordered;
	}

}
