package ua.com.internet_shop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.internet_shop.dao.DeliveryDao;
import ua.com.internet_shop.entity.Delivery;
import ua.com.internet_shop.service.DeliveryService;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService{

	@Autowired
	private DeliveryDao deliveryDao;
	
	public void save(Delivery delivery) {
		deliveryDao.save(delivery);
	}

	public List<Delivery> findAll() {
		return deliveryDao.findAll();
	}

	public Delivery findOne(int id) {
		return deliveryDao.findOne(id);
	}

	public void delete(int id) {
		deliveryDao.delete(id);
	}
	
}
