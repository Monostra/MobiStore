package ua.com.internet_shop.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import ua.com.internet_shop.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{
	
	@Query("select distinct c from Category c left join fetch c.goods")
	List<Category> findCatWithGoods();

	@Query("SELECT distinct g FROM Goods g LEFT JOIN FETCH g.category c LEFT JOIN FETCH g.images i WHERE c.id = :id")
	List<Category> findCategoryWithGoodsById(@Param("id") int id);
}
