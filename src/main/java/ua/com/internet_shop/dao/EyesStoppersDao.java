package ua.com.internet_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.com.internet_shop.entity.EyesStoppers;
import ua.com.internet_shop.entity.Goods;

import java.util.List;

public interface EyesStoppersDao extends JpaRepository<EyesStoppers, Short> {

    @Query("SELECT distinct g FROM Goods g LEFT JOIN FETCH g.images JOIN FETCH g.eyesStoppers e WHERE e.id = 1")
    List<Goods> findGoodsByTop();

    @Query("SELECT distinct g FROM Goods g LEFT JOIN FETCH g.images JOIN FETCH g.eyesStoppers e WHERE e.id = 2")
    List<Goods> findGoodsByNew();

    @Query("SELECT distinct g FROM Goods g LEFT JOIN FETCH g.images JOIN FETCH g.eyesStoppers e WHERE e.id = 3")
    List<Goods> findGoodsByDiscount();
}
