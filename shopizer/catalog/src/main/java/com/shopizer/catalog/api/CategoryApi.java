package com.shopizer.catalog.api;

import static com.shopizer.commonlibs.constants.DefaultConstants.DEFAULT_QUANTITY;
import static com.shopizer.commonlibs.constants.DefaultConstants.DEFAULT_STORE;
import static com.shopizer.commonlibs.constants.DefaultConstants.START_COUNT;
import static com.shopizer.commonlibs.constants.DefaultConstants.DEFAULT_LANG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopizer.catalog.api.utils.Constants;
import com.shopizer.catalog.facade.CategoryFacade;
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
@Tag(name = "category", description = "Category management API")
public class CategoryApi {
	
	
	@Autowired
	private CategoryFacade categoryFacade;
	


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
			@RequestParam(value = "store", required = false, defaultValue=DEFAULT_STORE) String store,//which store
			@RequestParam(value = "lang", required = false, defaultValue=DEFAULT_LANG) String language,//which language
			@RequestParam(value = "root", required = false) String root, //which root category
			@RequestParam(value = "page", required = false, defaultValue = START_COUNT) Integer page,
			@RequestParam(value = "count", required = false, defaultValue = DEFAULT_QUANTITY) Integer count) {
		

    	return categoryFacade.list(root, store, language, page, count);

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
