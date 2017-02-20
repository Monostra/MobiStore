package ua.com.internet_shop.service;

import ua.com.internet_shop.entity.Pages;

import java.util.List;

public interface PagesService {

    void save(Pages pages);
    List<Pages> findAll();
    Pages findOne(int id);
    void delete(int id);

}
