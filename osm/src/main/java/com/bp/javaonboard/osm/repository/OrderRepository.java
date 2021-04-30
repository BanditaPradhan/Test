package com.bp.javaonboard.osm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bp.javaonboard.osm.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String>{
 
}
