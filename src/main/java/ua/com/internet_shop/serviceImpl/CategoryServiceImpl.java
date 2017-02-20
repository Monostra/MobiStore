package ua.com.internet_shop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.internet_shop.dao.CategoryDao;
import ua.com.internet_shop.dao.GoodsDao;
import ua.com.internet_shop.entity.Category;
import ua.com.internet_shop.entity.Goods;
import ua.com.internet_shop.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private GoodsDao goodsDao;
	
	public void save(Category category) {
		categoryDao.save(category);
	}

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public Category findOne(int id) {
		return categoryDao.findOne(id);
	}

	public void delete(int id) {
		categoryDao.delete(id);
	}

	@Transactional
	public void addGoodToCat(Category category, int id) {
		categoryDao.saveAndFlush(category);
		Goods goods = goodsDao.findOne(id);
		goods.setCategory(category);
		goodsDao.save(goods);
	}

	public List<Category> findCatWithGoods() {
		return categoryDao.findCatWithGoods();
	}


	public List<Category> findCategoryWithGoodsById(int id) {
		return categoryDao.findCategoryWithGoodsById(id);
	}
}
