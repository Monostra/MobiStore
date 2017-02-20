package ua.com.internet_shop.service;

import ua.com.internet_shop.entity.News;

import java.util.List;

public interface NewsService {

    void save(News news);
    List<News> findAll();
    News findOne(int id);
    void delete(int id);
}
