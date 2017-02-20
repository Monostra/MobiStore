package ua.com.internet_shop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.internet_shop.dao.ReviewsDao;
import ua.com.internet_shop.entity.Reviews;
import ua.com.internet_shop.service.ReviewsService;

import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewsService{

    @Autowired
    private ReviewsDao reviewsDao;

    public void save(Reviews reviews) {
        reviewsDao.save(reviews);
    }

    public List<Reviews> findAll() {
        return reviewsDao.findAll();
    }

    public Reviews findOne(long id) {
        return reviewsDao.findOne(id);
    }

    public void delete(long id) {
        reviewsDao.delete(id);
    }
}
