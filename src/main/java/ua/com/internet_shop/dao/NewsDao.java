package ua.com.internet_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.internet_shop.entity.News;

public interface NewsDao extends JpaRepository<News, Integer> {
}
