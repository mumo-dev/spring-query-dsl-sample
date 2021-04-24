package io.mumo.springquerydsltut.service;

import io.mumo.springquerydsltut.model.Order;
import io.mumo.springquerydsltut.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderDTO> fetchAll(OrderFilter filterParam) {
      return orderRepository.findAll(filterParam);
    }

    private OrderDTO createDTO(Order order) {
        return OrderDTO.builder()
                .orderId(order.getId())
                .createdAt(order.getCreatedAt())
                .customerNames(order.getCustomer().getCustomerNames())
                .amount(order.getPayment().getAmount())
                .paymentMethod(order.getPayment().getId() + "")
                .build();
    }
}
