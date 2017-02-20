package ua.com.internet_shop.service;

import ua.com.internet_shop.entity.Delivery;

import java.util.List;

public interface DeliveryService{
	
	void save(Delivery delivery);
	List<Delivery> findAll();
	Delivery findOne(int id);
	void delete(int id);
}
