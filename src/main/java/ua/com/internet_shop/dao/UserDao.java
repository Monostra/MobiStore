package ua.com.internet_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.internet_shop.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
//	User findByName(String name);
	User findByLogin(String login);
	
	@Query("select distinct u from User u where u.id=:id")
	User findUserWithImage(@Param("id") int id);
	
	@Query("select case when count(u) > 0 then true else false end from User u where u.login =:login")
	boolean userExistByLogin(@Param("login") String login);

	@Query("select u from User u where u.uuid =:uuid")
	User findByUuid(@Param("uuid") String uuid);

//	@Query("SELECT case when count(u) > 0 then true else false end from User u where u.login =:login and u.password = :password")
//	boolean userLoginPassword(@Param("login") String login, @Param("password") String password);


}
