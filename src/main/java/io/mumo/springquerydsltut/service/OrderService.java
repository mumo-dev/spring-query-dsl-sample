package io.mumo.springquerydsltut.service;

import java.util.List;

public interface OrderService {

    List<OrderDTO> fetchAll(OrderFilter orderFilter);
}
