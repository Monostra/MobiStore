package ua.com.internet_shop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.internet_shop.dao.EyesStoppersDao;
import ua.com.internet_shop.entity.EyesStoppers;
import ua.com.internet_shop.entity.Goods;
import ua.com.internet_shop.service.EyesStoppersService;

import java.util.List;

@Service
public class EyesStoppersServiceImpl implements EyesStoppersService {

    @Autowired
    private EyesStoppersDao eyesStoppersDao;

    public void save(EyesStoppers eyesStoppers) {
        eyesStoppersDao.save(eyesStoppers);
    }

    public List<EyesStoppers> findAll() {
        return eyesStoppersDao.findAll();
    }

    public EyesStoppers findOne(short id) {
        return eyesStoppersDao.findOne(id);
    }

//    public void delete(short id) {
//        eyesStoppersDao.delete(id);
//    }


    public List<Goods> findGoodsByTop() {
        return eyesStoppersDao.findGoodsByTop();
    }

    public List<Goods> findGoodsByNew() {
        return eyesStoppersDao.findGoodsByNew();
    }

    public List<Goods> findGoodsByDiscount() {
        return eyesStoppersDao.findGoodsByDiscount();
    }
}
