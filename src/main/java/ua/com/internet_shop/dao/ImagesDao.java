package ua.com.internet_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.internet_shop.entity.Images;

public interface ImagesDao extends JpaRepository<Images, Integer>{
}
