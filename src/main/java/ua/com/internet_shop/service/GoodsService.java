package ua.com.internet_shop.service;

import org.springframework.web.multipart.MultipartFile;
import ua.com.internet_shop.entity.Goods;

import java.util.List;

public interface GoodsService{
	
	void save(Goods goods);
	List<Goods> findAll();
	Goods findOne(int id);
	void delete(int id);
	
	void addCatToGood(Goods goods, int id);
	
	List<Goods> findGoodsWithCategory();

	Object saveAndFlash(Goods goods);

	void saveGoodImg(int goodsId, MultipartFile[] multipartFile, String mainImg);

	List<Goods> findGoodsWithMainImg();

	Goods findGood(int goodsId);

	List<Goods> findAllGoods();

	List<Goods> liveSearch(String search);

	Goods findOneGoodsWithImg(int id);

}
