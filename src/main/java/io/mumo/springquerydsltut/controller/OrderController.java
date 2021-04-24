package io.mumo.springquerydsltut.controller;

import io.mumo.springquerydsltut.repository.OrderRepository;
import io.mumo.springquerydsltut.service.OrderDTO;
import io.mumo.springquerydsltut.service.OrderFilter;
import io.mumo.springquerydsltut.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @GetMapping("/search")
    public List<OrderDTO> search(OrderFilter orderFilter) {
        return orderService.fetchAll(orderFilter);
    }

//    @GetMapping()
//    public List<OrderDTO> fetchAll() {
//        return orderRepository.findAll();
//    }
}
