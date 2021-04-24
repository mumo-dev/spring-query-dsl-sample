package io.mumo.springquerydsltut.repository;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import io.mumo.springquerydsltut.model.*;
import io.mumo.springquerydsltut.service.OrderDTO;
import io.mumo.springquerydsltut.service.OrderFilter;
import io.mumo.springquerydsltut.service.OrderItemDTO;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.querydsl.core.types.Projections.constructor;

@Repository
public class CustomOrderRepositoryImpl extends QuerydslRepositorySupport implements CustomOrderRepository {

    public CustomOrderRepositoryImpl() {
        super(Order.class);
    }

    @Override
    public List<OrderDTO> findAll(OrderFilter filter) {
        QOrder order = QOrder.order;
        QOrderHistory orderHistory = QOrderHistory.orderHistory;
        QCustomer customer = QCustomer.customer;
        QPayment payment = QPayment.payment;
        QPaymentMethod paymentMethod = QPaymentMethod.paymentMethod;
        QOrderItem orderItem = QOrderItem.orderItem;

        JPQLQuery<OrderDTO> query = from(order)
                .select(constructor(OrderDTO.class,
                        order.id, order.createdAt,
                        customer.firstName, customer.lastName,
                        payment.amount, paymentMethod.name, orderHistory.orderStatus,
                        orderItem)
                )
                .innerJoin(customer).on(customer.id.eq(order.customer.id))
                .leftJoin(orderHistory)
                .on(orderHistory.order.id.eq(order.id)
                        .and(orderHistory.id.eq(JPAExpressions.select(orderHistory.id.max())
                                .from(orderHistory)
                                .where(orderHistory.order.id.eq(order.id)))))
                .leftJoin(payment).on(order.payment.id.eq(payment.id))
                .innerJoin(paymentMethod).on(payment.paymentMethod.id.eq(paymentMethod.id))
                .innerJoin(orderItem).on(orderItem.order.id.eq(order.id));

        if (filter.getFirstName() != null) {
            query = query.where(customer.firstName.likeIgnoreCase(filter.getFirstName()));
        }

        if (filter.getLastName() != null) {
            query = query.where(customer.lastName.likeIgnoreCase(filter.getLastName()));
        }

        if (filter.getOrderId() != null) {
            query = query.where(order.id.eq(filter.getOrderId()));
        }

        if (filter.getOrderStatus() != null) {
            OrderHistory.OrderStatus orderStatus = OrderHistory.OrderStatus.valueOf(filter.getOrderStatus().toUpperCase());
            query = query.where(orderHistory.orderStatus.eq(orderStatus));

        }

        if (filter.getPaymentMethod() != null) {
            query = query.where(payment.paymentMethod.name.eq(filter.getPaymentMethod()));
        }

        List<OrderDTO> orders = query
                .orderBy(order.id.desc())
                .fetch();


        return getGroupedOrderDTOs(orders);

    }

    @Override
    public List<Order> fetchAll(OrderFilter filter) {
        QOrder order = QOrder.order;
        QCustomer customer = QCustomer.customer;
        QPayment payment = QPayment.payment;
        QPaymentMethod paymentMethod = QPaymentMethod.paymentMethod;

        JPQLQuery<Order> query = from(order)
                .innerJoin(customer, order.customer)
                .leftJoin(payment).on(order.payment.id.eq(payment.id))
                .innerJoin(paymentMethod).on(payment.paymentMethod.id.eq(paymentMethod.id));

        if (filter.getFirstName() != null) {
            query = query.where(customer.firstName.likeIgnoreCase(filter.getFirstName()));
        }

        if (filter.getLastName() != null) {
            query = query.where(customer.lastName.likeIgnoreCase(filter.getLastName()));
        }

        if (filter.getOrderId() != null) {
            query = query.where(order.id.eq(filter.getOrderId()));
        }


        if (filter.getPaymentMethod() != null) {
            query = query.where(payment.paymentMethod.name.eq(filter.getPaymentMethod()));
        }

        return query.orderBy(order.id.asc()).fetch();
    }

    private List<OrderDTO> getGroupedOrderDTOs(List<OrderDTO> orders) {
        List<OrderDTO> ordersList = new ArrayList<>();

        orders.forEach(orderDTO -> {
            Optional<OrderDTO> found = ordersList.stream()
                    .filter(orderDTO1 -> orderDTO1.getOrderId().equals(orderDTO.getOrderId()))
                    .findFirst();

            List<OrderItemDTO> orderItems = new ArrayList<>();
            if (found.isPresent()) {
                orderItems = found.get().getOrderItems();
            } else {
                ordersList.add(orderDTO);
            }
            orderItems.add(orderDTO.getOrderItem());
            orderDTO.setOrderItems(orderItems);

        });
        return ordersList;
    }
}


