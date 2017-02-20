package ua.com.internet_shop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ua.com.internet_shop.dao.CategoryDao;
import ua.com.internet_shop.dao.GoodsDao;
import ua.com.internet_shop.dao.ImagesDao;
import ua.com.internet_shop.entity.Category;
import ua.com.internet_shop.entity.Goods;
import ua.com.internet_shop.entity.Images;
import ua.com.internet_shop.service.GoodsService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ImagesDao imagesDao;
	
	public void save(Goods goods) {
		goodsDao.save(goods);
	}

	public List<Goods> findAll() {
		return goodsDao.findAll();
	}

	public Goods findOne(int id) {
		return goodsDao.findOne(id);
	}

	public void delete(int id) {
		goodsDao.delete(id);
	}

	public void addCatToGood(Goods goods, int id) {
		Category category = categoryDao.findOne(id);
		goods.setCategory(category);
	}

	public List<Goods> findGoodsWithCategory() {
		return goodsDao.findGoodsWithCategory();
	}


//	@Transactional
//	public void addCatToGood(Goods goods, int id) {
//		goodsDao.saveAndFlush(goods);
//		Category category = categoryDao.findOne(id);
//		goods.setCategory(category);
//	}
	@Transactional
	public void saveGoodImg(int goodsId, MultipartFile[] multipartFile, String mainImg) {
//		User user = userDao.findOne(Integer.parseInt(principal.getName()));
		Goods goods = goodsDao.findOne(goodsId);

		int i = 1;
		for (MultipartFile img: multipartFile){
			Images images = new Images();
			String path = System.getProperty("catalina.home") + "/resourcesGoods/" + goods.getId() + "/" + img.getOriginalFilename();
			images.setPahtImg("resourcesGoods/" + goods.getId() + "/" + img.getOriginalFilename());
			if (i == Integer.parseInt(mainImg)){
				images.setMainImg(true);
			} else {
				images.setMainImg(false);
			}
			images.setGoods(goods);
			File file = new File(path);

			try {
				file.mkdirs();
//				try {
//					FileUtils.cleanDirectory
//							(new File(System.getProperty("catalina.home") + "/resources/" + goods.getId() + "/"));
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
				img.transferTo(file);
			} catch (IOException e) {
				System.out.println("error with file");
			}
			imagesDao.save(images);
			i++;
		}

	}


	public Goods saveAndFlash(Goods goods) {
		Object o = new Goods();
		o = goodsDao.saveAndFlush(goods);
		return (Goods) o;
	}

	public List<Goods> findGoodsWithMainImg() {
		return goodsDao.findGoodsWithMainImg();
	}

	public Goods findGood(int goodsId) {
		return goodsDao.findGood(goodsId);
	}

	public List<Goods> findAllGoods() {
		return goodsDao.findAllGoods();
	}

	public List<Goods> liveSearch(String search) {
		return goodsDao.liveSearch(search);
	}

	public Goods findOneGoodsWithImg(int id) {
		return goodsDao.findOneGoodsWithImg(id);
	}
}
