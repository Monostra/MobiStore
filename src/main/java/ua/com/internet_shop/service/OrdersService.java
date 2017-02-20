package ua.com.internet_shop.service;

import ua.com.internet_shop.entity.Orders;

import java.util.List;

public interface OrdersService{
	
	void save(Orders orders);
	List<Orders> findAll();
	Orders findOne(int id);
	void delete(int id);

	Orders SaveAndFlash(Orders orders);


}
