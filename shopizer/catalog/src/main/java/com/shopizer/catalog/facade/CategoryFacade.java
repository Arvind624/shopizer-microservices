package com.shopizer.catalog.facade;

import com.shopizer.commonlibs.apis.ReadableList;
import com.shopizer.model.category.ReadableCategory;

public interface CategoryFacade {
	
	

	/**
	 * List category from a specific root
	 * @param root
	 * @param store
	 * @param language
	 * @param page
	 * @param count
	 * @return
	 */
	ReadableList<ReadableCategory> list(String root, String store, String language, int page, int count);
	
	/**
	 * 
	 * @param store
	 * @param category
	 * @return PersistableCategory
	 */
	//PersistableCategory saveCategory(MerchantStore store, PersistableCategory category);
	
	/**
	 * 
	 * @param store
	 * @param id
	 * @param language
	 * @return ReadableCategory
	 */
	//ReadableCategory getById(MerchantStore store, Long id, Language language);
	
	/**
	 * 
	 * @param store
	 * @param code
	 * @param language
	 * @return ReadableCategory
	 * @throws Exception
	 */
	//ReadableCategory getByCode(MerchantStore store, String code, Language language) throws Exception;

	//Category getByCode(String code, MerchantStore store);
	
	//void deleteCategory(Long categoryId, MerchantStore store);

	//void deleteCategory(Category category);
	
	
	/**
	 * List product options variations for a given category
	 * @param categoryId
	 * @param store
	 * @param language
	 * @return
	 */
	//List<ReadableProductVariant> categoryProductVariants(Long categoryId, MerchantStore store, Language language);

	/**
	 * Check if category code already exist
	 * @param store
	 * @param code
	 * @return
	 * @throws Exception
	 */
	//boolean existByCode(MerchantStore store, String code);
	
	/**
	 * Move a Category from a node to another node
	 * @param child
	 * @param parent
	 * @param store
	 */
	//void move(Long child, Long parent, MerchantStore store);
	
	/**
	 * Set category visible or not
	 * @param category
	 * @param store
	 */
	//void setVisible(PersistableCategory category, MerchantStore store);

}
