package ua.com.internet_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.internet_shop.entity.Orders;

public interface OrdersDao extends JpaRepository<Orders, Integer>{



}
