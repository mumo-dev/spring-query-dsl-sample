package io.mumo.springquerydsltut.repository;

import io.mumo.springquerydsltut.model.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
}
