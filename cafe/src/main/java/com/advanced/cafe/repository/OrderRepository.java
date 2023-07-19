package com.advanced.cafe.repository;

import com.advanced.cafe.entity.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderList, Long> {
}
