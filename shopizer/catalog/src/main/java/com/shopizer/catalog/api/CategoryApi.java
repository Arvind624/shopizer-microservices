package com.shopizer.catalog.api;

import static com.shopizer.commonlibs.constants.DefaultConstants.DEFAULT_QUANTITY;
import static com.shopizer.commonlibs.constants.DefaultConstants.DEFAULT_STORE;
import static com.shopizer.commonlibs.constants.DefaultConstants.START_COUNT;
import static com.shopizer.commonlibs.constants.DefaultConstants.DEFAULT_LANG;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopizer.catalog.api.utils.Constants;
import com.shopizer.commonlibs.apis.ReadableList;
import com.shopizer.model.category.ReadableCategory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = Constants.API_VERSION)
//@Api(tags = { "Category management resource (Category Management Api)" })
//@SwaggerDefinition(tags = {
//		@Tag(name = "Category management resource", description = "Manage category and attached products") })
@Tag(name = "category", description = "Category management API")
public class CategoryApi {

	
	/**
	@GetMapping(value = "/category", produces = { APPLICATION_JSON_VALUE })
	@ApiOperation(httpMethod = "GET", value = "Get category hierarchy from root. Supports filtering FEATURED_CATEGORIES and VISIBLE ONLY by adding ?filter=[featured] or ?filter=[visible] or ? filter=[featured,visible", notes = "Does not return any product attached")
	@ApiImplicitParams({ @ApiImplicitParam(name = "store", dataType = "string", defaultValue = "DEFAULT"),
			@ApiImplicitParam(name = "lang", dataType = "string", defaultValue = "en") })**/
	/**
	 * Public method
	 * @param code
	 * @param name
	 * @param page
	 * @param count
	 * @return
	 */
    @Operation(summary = "List category hierarchy", description = "List category from root or starting from category %code%", tags = { "ctegory hierarchy" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", 
                content = @Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))) })	
    @GetMapping(value = "/category", produces = { "application/json" })
	public ReadableList<ReadableCategory> list(
			@RequestParam(value = "store", required = false, defaultValue=DEFAULT_STORE) String code,//which store
			@RequestParam(value = "lang", required = false, defaultValue=DEFAULT_LANG) String language,//which language
			@RequestParam(value = "name", required = false) String name,//filter name
			@RequestParam(value = "root", required = false) String root, //which root category
			@RequestParam(value = "page", required = false, defaultValue = START_COUNT) Integer page,
			@RequestParam(value = "count", required = false, defaultValue = DEFAULT_QUANTITY) Integer count) {
		
		
		//ListCriteria criteria = new ListCriteria();
		//criteria.setName(name);
		//return categoryFacade.getCategoryHierarchy(merchantStore, criteria, DEFAULT_CATEGORY_DEPTH, language, filter,
		//		page, count);
		return null;
	}
    
    
    /**
     * Category details (YES)
     */
	

    /**
     * Create category (NO)
     */
    
    /**
     * Edit category (NO)
     */
    
    /**
     * Remove category (NO)
     */
    
    /**
     * Category unique (NO)
     */
    
    /**
     * Move category (NO)
     */
    
    /**
     * Update visible (patch) (NO)
     */

}
