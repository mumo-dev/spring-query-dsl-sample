package io.mumo.springquerydsltut.repository;

import io.mumo.springquerydsltut.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
