package ua.com.internet_shop.service;

import ua.com.internet_shop.entity.Cart;

import java.security.Principal;
import java.util.List;

public interface CartService {

    void save(Cart cart);
    List<Cart> findAll();
    Cart findOne(int id);
    void delete(int id);

    void buyGood(int id, Principal principal);

    Cart findGoods(int goods_id, int user_id);

    List<Cart> allGoods(int user);

    Object totalQuantityAndPrice(int userId);

//    void deleteByUser(int userId);
    List<Cart> cartByUser(int userId);
}
