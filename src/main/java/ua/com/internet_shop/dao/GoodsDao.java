package ua.com.internet_shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import ua.com.internet_shop.entity.Goods;

public interface GoodsDao extends JpaRepository<Goods, Integer>{
	
	@Query("select g from Goods g left join fetch g.category")
	List<Goods> findGoodsWithCategory();

//	@Query("SELECT i FROM Images i JOIN FETCH i.goods g WHERE g.id = :goodsId")
//	Goods findGoodsWithMainImg(@Param("goodsId") int goodsId);

	@Query("SELECT distinct g FROM Goods g LEFT JOIN FETCH g.images")
	List<Goods> findGoodsWithMainImg();

	@Query("SELECT DISTINCT g FROM Goods g LEFT JOIN FETCH g.images WHERE g.id = :id")
	Goods findOneGoodsWithImg(@Param("id") int id);

	@Query("SELECT DISTINCT g FROM Goods g LEFT JOIN FETCH g.images LEFT JOIN FETCH g.category LEFT JOIN FETCH g.eyesStoppers WHERE g.id = :goodsId")
	Goods findGood(@Param("goodsId") int goodsId);

	@Query("SELECT distinct g FROM Goods g LEFT JOIN FETCH g.images")
	List<Goods> findAllGoods();

	@Query("SELECT distinct g FROM Goods g LEFT JOIN FETCH g.images WHERE g.name LIKE CONCAT('%',:search,'%') ")
	List<Goods> liveSearch(@Param("search") String search);




}
