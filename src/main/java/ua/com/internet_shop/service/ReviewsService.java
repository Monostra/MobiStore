package ua.com.internet_shop.service;

import ua.com.internet_shop.entity.Reviews;

import java.util.List;

public interface ReviewsService {

    void save(Reviews reviews);
    List<Reviews> findAll();
    Reviews findOne(long id);
    void delete(long id);
}
