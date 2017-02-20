package ua.com.internet_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.internet_shop.entity.Reviews;

public interface ReviewsDao extends JpaRepository<Reviews, Long> {
}
