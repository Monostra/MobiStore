package ua.com.internet_shop.serviceImpl;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ua.com.internet_shop.dao.GoodsDao;
import ua.com.internet_shop.dao.UserDao;
import ua.com.internet_shop.entity.Goods;
import ua.com.internet_shop.entity.Role;
import ua.com.internet_shop.entity.User;
import ua.com.internet_shop.service.UserService;
import ua.com.internet_shop.validation.Validator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService{
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private GoodsDao goodsDao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	@Transactional
	public void save(User user) throws Exception {
		
		validator.validate(user);
		
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findOne(int id) {
		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);
	}

	public User findByLogin(String login) {
		return userDao.findByLogin(login);
	}

	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		return userDao.findByLogin(login);
	}


	@Transactional
	public void saveImage(Principal principal, MultipartFile multipartFile) {
		User user = userDao.findOne(Integer.parseInt(principal.getName()));

	    String path = System.getProperty("catalina.home") + "/resourcesUser/"
	            + user.getLogin() + "/" + multipartFile.getOriginalFilename();

	    user.setPathImg("resourcesUser/" + user.getLogin() + "/" + multipartFile.getOriginalFilename());

	    File file = new File(path);

	    try {
	        file.mkdirs();
	        try {
	            FileUtils.cleanDirectory
	                    (new File(System.getProperty("catalina.home") + "/resourcesUser/" + user.getLogin() + "/"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        multipartFile.transferTo(file);
	    } catch (IOException e) {
	        System.out.println("error with file");
	    }
	    userDao.save(user);

	}

	public User findUserWithImage(int id) {
		return userDao.findUserWithImage(id);
	}

	@Override
	public User findByUuid(String uuid) {
		return userDao.findByUuid(uuid);
	}

	@Override
	public void update(User user) {
		userDao.save(user);
	}

	// for Cookie
	@Override
	public Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response) {
		request.getSession(false);
		Goods goods = goodsDao.findOne(id);

		Cookie cookieGood = new Cookie(goods.getName(), String.valueOf(goods.getId()));
		cookieGood.setMaxAge(24*60*60*60);
		cookieGood.setHttpOnly(true);
		cookieGood.setPath("/");

		response.addCookie(cookieGood);
		return cookieGood;
	}

	@Override
	public List<Goods> userGoodsCookie(HttpServletRequest request) {
		request.getSession(false);
		List<Goods> goods = new ArrayList<>();
		for (Cookie cookie: request.getCookies()) {
			if (cookie.getName().equals("JSESSIONID")){
			}else{
				goods.add(goodsDao.findOne(Integer.parseInt(cookie.getValue())));
			}
		}
		return goods;
	}

	@Override
	public void deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		sortCookie(cookies, id, response);
	}

	public void sortCookie(Cookie[] cookies, String id, HttpServletResponse response){
		for (int i = 0; i < cookies.length; i++){
			if (id.equals(cookies[i].getValue())){
				Cookie cookie = new Cookie(cookies[i].getName(), null);
				cookie.setPath("/");
				cookie.setValue(null);
				cookie.setHttpOnly(true);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}


}
