package ua.com.internet_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;
import ua.com.internet_shop.entity.Cart;

import java.util.List;

public interface CartDao extends JpaRepository<Cart, Integer> {

    @Query("SELECT c FROM Cart c JOIN FETCH c.goods g join fetch c.user u WHERE g.id = :goods_id AND u.id = :user_id")
    Cart findGoods(@Param("goods_id") int goods_id, @Param("user_id") int user_id);

//    @Query("SELECT c FROM Cart c JOIN FETCH c.goods g WHERE g.id = :goods_id AND c.userIP = :ip")
//    Cart findGoodsByIP(@Param("goods_id") int goods_id, @Param("ip") String ip);

    @Query("SELECT c FROM Cart c JOIN FETCH c.goods JOIN FETCH c.user u WHERE u.id = :user")
    List<Cart> allGoods(@Param("user") int user);

//    @Query("SELECT c FROM Cart c JOIN FETCH c.goods WHERE c.userIP = :ip")
//    List<Cart> allGoodsByIP(@Param("ip") String ip);

//    @Query(value = "SELECT SUM(c.quantity), SUM (c.quantity*g.price) FROM Cart c INNER JOIN Goods g ON g.id = c.goods.id GROUP BY c.userIP")
//    Object totalQuantityAndPriceByIP();

    @Query(value = "SELECT SUM(c.quantity), SUM (c.quantity*g.price) FROM Cart c INNER JOIN Goods g ON g.id = c.goods.id INNER JOIN User u on u.id = c.user.id WHERE u.id = :userId GROUP BY u.id")
    Object totalQuantityAndPrice(@Param("userId") int userId);

//    @Query(value = "DELETE FROM Cart c WHERE c.user.id = :userId")
//    void deleteById(@Param("userId") int userId);
    @Query("SELECT c FROM Cart c JOIN FETCH c.user u WHERE u.id = :userId")
    List<Cart> cartByUser(@Param("userId") int userId);


//    @Query(value = "SELECT SUM (c.quantity) as totalQuantity, SUM (g.price) as totalPrica FROM Cart c WHERE c.user_id = :userId GROUP BY c.user_id",nativeQuery = true)
//    Object totalQuantityAndPrice (@Param("userId") int userId);

}
