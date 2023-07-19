package com.advanced.cafe.repository;

import com.advanced.cafe.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
