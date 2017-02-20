package ua.com.internet_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.internet_shop.entity.Zakaz;

import java.util.List;

public interface ZakazDao extends JpaRepository<Zakaz, Integer>{

    @Query("SELECT DISTINCT z FROM Zakaz z JOIN FETCH z.orders o JOIN FETCH z.goods JOIN FETCH o.user u WHERE u.id = :userId")
    List<Zakaz> findZakazByUser(@Param("userId") int userId);

}
