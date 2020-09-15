package com.shopizer.catalog.facade;

import org.springframework.stereotype.Component;

import com.shopizer.commonlibs.apis.ReadableList;
import com.shopizer.model.category.ReadableCategory;

@Component
public class CategoryFacadeImpl implements CategoryFacade {

	@Override
	public ReadableList<ReadableCategory> list(String root, String store, String language, int page, int count) {
		// TODO Auto-generated method stub
		return null;
	}

}
