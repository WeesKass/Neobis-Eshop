package com.neobis.eshop.repository;

import com.neobis.eshop.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <OrderEntity, Integer> {
}
