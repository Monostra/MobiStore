package ua.com.internet_shop.editor;

import ua.com.internet_shop.service.CategoryService;

import java.beans.PropertyEditorSupport;

public class CategoryEditor extends PropertyEditorSupport{

	private final CategoryService categoryService;

	public CategoryEditor(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(categoryService.findOne(Integer.parseInt(text)));
	}
	
	

}
