package io.mumo.springquerydsltut.repository;

import io.mumo.springquerydsltut.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface OrderRepository extends JpaRepository<Order, Long>,
        QuerydslPredicateExecutor<Order>, CustomOrderRepository {

}
