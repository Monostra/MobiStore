package ua.com.internet_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.internet_shop.entity.Delivery;

public interface DeliveryDao extends JpaRepository<Delivery, Integer>{

}
