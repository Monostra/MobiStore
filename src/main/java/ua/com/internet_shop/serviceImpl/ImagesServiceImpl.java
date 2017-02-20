package ua.com.internet_shop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.internet_shop.dao.ImagesDao;
import ua.com.internet_shop.entity.Images;
import ua.com.internet_shop.service.ImagesService;

import java.util.List;

@Service
public class ImagesServiceImpl implements ImagesService {

    @Autowired
    private ImagesDao imagesDao;

    public void save(Images images) {
        imagesDao.save(images);
    }

    public List<Images> findAll() {
        return imagesDao.findAll();
    }

    public Images findOne(int id) {
        return imagesDao.findOne(id);
    }

    public void delete(int id) {
        imagesDao.delete(id);
    }
}
