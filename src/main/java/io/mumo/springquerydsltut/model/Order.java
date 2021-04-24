package io.mumo.springquerydsltut.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    private ZonedDateTime createdAt;

    @OneToMany(mappedBy = "order")
    private Set<OrderHistory> orderHistories;



    public Order(Long id, Customer customer, Payment payment, ZonedDateTime createdAt) {
        this.id = id;
        this.customer = customer;
        this.payment = payment;
        this.createdAt = createdAt;
    }



    @PrePersist
    public void initCreateDate() {
        this.createdAt = ZonedDateTime.now();
    }
}
