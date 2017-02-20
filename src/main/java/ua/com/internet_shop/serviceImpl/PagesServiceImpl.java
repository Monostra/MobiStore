package ua.com.internet_shop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.internet_shop.dao.PagesDao;
import ua.com.internet_shop.entity.Pages;
import ua.com.internet_shop.service.PagesService;

import java.util.List;

@Service
public class PagesServiceImpl implements PagesService{

    @Autowired
    private PagesDao pagesDao;

    public void save(Pages pages) {
        pagesDao.save(pages);
    }

    public List<Pages> findAll() {
        return pagesDao.findAll();
    }

    public Pages findOne(int id) {
        return pagesDao.findOne(id);
    }

    public void delete(int id) {
        pagesDao.delete(id);
    }



}
