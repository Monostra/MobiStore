package ua.com.internet_shop.service;

import ua.com.internet_shop.entity.Category;

import java.util.List;

public interface CategoryService{
	
	void save(Category t);
	List<Category> findAll();
	Category findOne(int id);
	void delete(int id);

	void addGoodToCat(Category category, int id);
	
	List<Category> findCatWithGoods();

	List<Category> findCategoryWithGoodsById(int id);
	
}
