package ua.com.internet_shop.service;

import org.springframework.web.multipart.MultipartFile;
import ua.com.internet_shop.entity.Goods;
import ua.com.internet_shop.entity.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;



public interface UserService {
	
	void save(User user) throws Exception;
	List<User> findAll();
	User findOne(int id);
	void delete(int id);
	
//	User findByName(String name);
	User findByLogin(String login);
	
	User findUserWithImage(int id);
	
	void saveImage(Principal principal, MultipartFile multipartFile);
	
	User findByUuid(String uuid);
	void update(User user);

	// for Cookie

	Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response);
	List<Goods> userGoodsCookie(HttpServletRequest request);
//	void getOrder
	void  deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response);
}
