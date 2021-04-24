package io.mumo.springquerydsltut.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.mumo.springquerydsltut.model.OrderHistory;
import io.mumo.springquerydsltut.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {

    private Long orderId;
    private ZonedDateTime createdAt;
    private String customerNames;
    private Double amount;
    private String paymentMethod;
    private OrderHistory.OrderStatus orderStatus;

    @JsonIgnore
    private OrderItemDTO orderItem;
    private List<OrderItemDTO> orderItems;

    public OrderDTO(Long orderId, ZonedDateTime createdAt,
                    String firstName, String lastName,
                    Double amount, String paymentMethod, OrderHistory.OrderStatus orderStatus,
                    OrderItem orderItem) {

        this.orderId = orderId;
        this.createdAt = createdAt;
        this.customerNames = firstName + " " + lastName;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.orderStatus = orderStatus;
        createOrderItemDTO(orderItem);

    }

    private void createOrderItemDTO(OrderItem orderItem) {

        this.orderItem = new OrderItemDTO();
        this.orderItem.setOrderId(orderItem.getOrder().getId());
        this.orderItem.setPrice(orderItem.getPrice());
        this.orderItem.setId(orderItem.getId());
        this.orderItem.setProductId(orderItem.getProductId());
        this.orderItem.setQuantity(orderItem.getQuantity());
    }
}
