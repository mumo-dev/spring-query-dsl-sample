package io.mumo.springquerydsltut.repository;

import io.mumo.springquerydsltut.model.Order;
import io.mumo.springquerydsltut.service.OrderDTO;
import io.mumo.springquerydsltut.service.OrderFilter;

import java.util.List;

public interface CustomOrderRepository {
    List<OrderDTO> findAll(OrderFilter filterParams);
    List<Order> fetchAll(OrderFilter filterParams);
}
