package ua.com.internet_shop.service;

import ua.com.internet_shop.entity.Images;

import java.util.List;

public interface ImagesService {

    void save(Images images);
    List<Images> findAll();
    Images findOne(int id);
    void delete(int id);
}
