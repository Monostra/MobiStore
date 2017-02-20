package ua.com.internet_shop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.internet_shop.dao.OrdersDao;
import ua.com.internet_shop.entity.Orders;
import ua.com.internet_shop.service.OrdersService;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	private OrdersDao ordersDao;
	
	public void save(Orders orders) {
		ordersDao.save(orders);
	}

	public List<Orders> findAll() {
		return ordersDao.findAll();
	}

	public Orders findOne(int id) {
		return ordersDao.findOne(id);
	}

	public void delete(int id) {
		ordersDao.delete(id);
	}


	@Override
	public Orders SaveAndFlash(Orders orders) {
//		Object o = new Orders();
//		o = ordersDao.saveAndFlush(orders);
//		return (Orders) o;
		return ordersDao.saveAndFlush(orders);
	}
}
