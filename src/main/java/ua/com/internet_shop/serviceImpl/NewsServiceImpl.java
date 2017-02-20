package ua.com.internet_shop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.internet_shop.dao.NewsDao;
import ua.com.internet_shop.entity.News;
import ua.com.internet_shop.service.NewsService;

import java.util.List;

@Service
public class NewsServiceImpl  implements NewsService{

    @Autowired
    private NewsDao newsDao;

    public void save(News news) {
        newsDao.save(news);
    }

    public List<News> findAll() {
        return newsDao.findAll();
    }

    public News findOne(int id) {
        return newsDao.findOne(id);
    }

    public void delete(int id) {
        newsDao.delete(id);
    }
}
