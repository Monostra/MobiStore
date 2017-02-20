package ua.com.internet_shop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.internet_shop.dao.ZakazDao;
import ua.com.internet_shop.entity.Zakaz;
import ua.com.internet_shop.service.ZakazService;

import java.util.List;

@Service
public class ZakazServiceImpl implements ZakazService{

	@Autowired
	private ZakazDao zakazDao;
	
	public void save(Zakaz zakaz) {
		zakazDao.save(zakaz);
	}

	public List<Zakaz> findAll() {
		return zakazDao.findAll();
	}

	public Zakaz findOne(int id) {
		return zakazDao.findOne(id);
	}

	public void delete(int id) {
		zakazDao.delete(id);
	}

	public List<Zakaz> findZakazByUser(int userId) {
		return zakazDao.findZakazByUser(userId);
	}
}
