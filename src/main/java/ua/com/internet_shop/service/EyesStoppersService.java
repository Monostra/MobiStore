package ua.com.internet_shop.service;

import ua.com.internet_shop.entity.EyesStoppers;
import ua.com.internet_shop.entity.Goods;

import java.util.List;

public interface EyesStoppersService {

    void save(EyesStoppers eyesStoppers);
    List<EyesStoppers> findAll();
    EyesStoppers findOne(short id);
//    void delete(short id);

    List<Goods> findGoodsByTop();
    List<Goods> findGoodsByNew();
    List<Goods> findGoodsByDiscount();
}
