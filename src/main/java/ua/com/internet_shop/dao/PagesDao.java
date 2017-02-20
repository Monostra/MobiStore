package ua.com.internet_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.internet_shop.entity.Pages;

public interface PagesDao extends JpaRepository<Pages, Integer> {
}
