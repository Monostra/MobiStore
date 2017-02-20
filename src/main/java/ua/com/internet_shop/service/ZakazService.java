package ua.com.internet_shop.service;

import ua.com.internet_shop.entity.Zakaz;

import java.util.List;

public interface ZakazService {
	
	void save(Zakaz zakaz);
	List<Zakaz> findAll();
	Zakaz findOne(int id);
	void delete(int id);


	List<Zakaz> findZakazByUser(int userId);
}
