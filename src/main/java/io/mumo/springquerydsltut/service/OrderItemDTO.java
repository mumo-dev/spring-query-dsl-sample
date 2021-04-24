package io.mumo.springquerydsltut.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItemDTO {
    private Long id;
    private Long orderId;
    private Long productId;
    private Double price;
    private Integer quantity;
}
