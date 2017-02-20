package ua.com.internet_shop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.internet_shop.dao.CartDao;
import ua.com.internet_shop.dao.GoodsDao;
import ua.com.internet_shop.dao.UserDao;
import ua.com.internet_shop.entity.Cart;
import ua.com.internet_shop.service.CartService;

import java.security.Principal;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private UserDao userDao;


    public void save(Cart cart) {
        cartDao.save(cart);
    }

    public List<Cart> findAll() {
        return cartDao.findAll();
    }

    public Cart findOne(int id) {
        return cartDao.findOne(id);
    }

    public void delete(int id) {
        cartDao.delete(id);
    }

    public Cart findGoods(int goods_id, int user_id) {
        return cartDao.findGoods(goods_id, user_id);
    }

    public List<Cart> allGoods(int user) {
        return cartDao.allGoods(user);
    }

    public Object totalQuantityAndPrice(int userId) {
        return cartDao.totalQuantityAndPrice(userId);
    }

    @Transactional
    public void buyGood(int id, Principal principal) {
        Cart cart = null;
        short quantity;
        if (principal != null){
            int user_id = Integer.parseInt(principal.getName());
            if (cartDao.findGoods(id, user_id) == null) {
                cart = new Cart();
                quantity = 1;
                cart.setUser(userDao.findOne(user_id));
                cart.setGoods(goodsDao.findOne(id));
            } else {
                int cart_id = cartDao.findGoods(id, user_id).getId();
                cart = cartDao.findOne(cart_id);
                quantity = cartDao.findGoods(id, user_id).getQuantity();
                quantity += 1;
            }
            cart.setQuantity(quantity);
        }
        cartDao.save(cart);
    }

    public List<Cart> cartByUser(int userId) {
        return cartDao.cartByUser(userId);
    }

    //    public void deleteByUser(int userId) {
//        cartDao.deleteByUser(userId);
//    }

    //    public List<Goods> click(HttpServletRequest request){
//        request.getSession();
//        Cookie [] cookies = request.getCookies();
//        List<Goods> goodss = new ArrayList<>();
//        for (Cookie cookie: cookies) {
//            goodss.add(cookie.getValue().indexOf());
//        }
//    }

}
