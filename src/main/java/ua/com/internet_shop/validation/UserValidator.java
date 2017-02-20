package ua.com.internet_shop.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.internet_shop.dao.UserDao;
import ua.com.internet_shop.entity.User;

@Component("userValidator")
public class UserValidator implements Validator{
	
	@Autowired
	private UserDao userDao;

	public void validate(Object object) throws Exception {
		
		User user = (User) object;
		
		if (user.getLogin().isEmpty()) {
			throw new UserValidatationExeption(UserValidationMasages.EMPTY_LOGIN_FIELD);
		}
		if (userDao.userExistByLogin(user.getLogin())) {
			throw new UserValidatationExeption(UserValidationMasages.LOGIN_ALREADY_EXIST);
		}
		if (user.getPassword().isEmpty()) {
			throw new UserValidatationExeption(UserValidationMasages.EMPTY_PASSWORD_FIELD);
		}

		
		
	}
	
	

}
