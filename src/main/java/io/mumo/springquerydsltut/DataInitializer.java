package io.mumo.springquerydsltut;

import io.mumo.springquerydsltut.model.*;
import io.mumo.springquerydsltut.model.OrderHistory.OrderStatus;
import io.mumo.springquerydsltut.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class DataInitializer implements ApplicationRunner {

    private final CustomerRepository customerRepository;
    private final OrderHistoryRepository orderHistoryRepository;
    private final OrderRepository orderRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final PaymentRepository paymentRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        insertData();
    }

    // insert paymentMethods
    // insert customer
    // insert payment
    // insert order
    // insert orderHistory
    private void insertData() {
        insertPaymentMethods();
        insertCustomers();
        insertPayment();
        insertOrders();
        insertOrderHistory();
        insertOrderItems();
    }

    private void insertPaymentMethods() {

        PaymentMethod paymentMethod1 = new PaymentMethod();
        paymentMethod1.setName("CARD");

        PaymentMethod paymentMethod2 = new PaymentMethod();
        paymentMethod2.setName("PAYPAL");

        paymentMethodRepository.saveAll(
                Arrays.asList(paymentMethod1, paymentMethod2)
        );
    }

    private void insertCustomers() {
        Customer customer1 = new Customer(1L, "John", "Doe");
        Customer customer2 = new Customer(2L, "Jane", "Doe");

        customerRepository.saveAll(Arrays.asList(
                customer1, customer2
        ));
    }

    private void insertPayment() {
        Customer customer1 = customerRepository.getOne(1L);
        Customer customer2 = customerRepository.getOne(2L);

        PaymentMethod paymentMethod1 = paymentMethodRepository.getOne(1L);
        PaymentMethod paymentMethod2 = paymentMethodRepository.getOne(2L);

        Payment payment1 = new Payment(1L, 200.0, ZonedDateTime.now(), customer1, paymentMethod1);
        Payment payment2 = new Payment(2L, 100.0, ZonedDateTime.now(), customer2, paymentMethod1);
        Payment payment3 = new Payment(3L, 1200.0, ZonedDateTime.now(), customer2, paymentMethod1);
        Payment payment4 = new Payment(4L, 400.0, ZonedDateTime.now(), customer1, paymentMethod2);
        Payment payment5 = new Payment(5L, 50.0, ZonedDateTime.now(), customer2, paymentMethod2);


        paymentRepository.saveAll(Arrays.asList(payment1, payment2, payment3, payment4, payment5));
    }

    private void insertOrders() {
        Customer customer1 = customerRepository.getOne(1L);
        Customer customer2 = customerRepository.getOne(2L);

        Payment payment1 = paymentRepository.getOne(1L);
        Payment payment2 = paymentRepository.getOne(2L);
        Payment payment3 = paymentRepository.getOne(3L);
        Payment payment4 = paymentRepository.getOne(4L);
        Payment payment5 = paymentRepository.getOne(5L);

        Order order1 = new Order(1L, customer1, payment1, ZonedDateTime.now());
        Order order2 = new Order(2L, customer2, payment2, ZonedDateTime.now());
        Order order3 = new Order(3L, customer2, payment3, ZonedDateTime.now());
        Order order4 = new Order(4L, customer1, payment4, ZonedDateTime.now());
        Order order5 = new Order(5L, customer2, payment5, ZonedDateTime.now());

        orderRepository.saveAll(Arrays.asList(order1, order2, order3, order4, order5));
    }

    private void insertOrderHistory() {


        Order order1 = orderRepository.getOne(1L);
        Order order2 = orderRepository.getOne(2L);
        Order order3 = orderRepository.getOne(3L);
        Order order4 = orderRepository.getOne(4L);
        Order order5 = orderRepository.getOne(5L);

        OrderHistory orderHistory1 = new OrderHistory(1L, OrderStatus.ACCEPTED, ZonedDateTime.now(), order1);
        OrderHistory orderHistory2 = new OrderHistory(2L, OrderStatus.COMPLETED, ZonedDateTime.now(), order1);

        OrderHistory orderHistory3 = new OrderHistory(3L, OrderStatus.CREATED, ZonedDateTime.now(), order2);
        OrderHistory orderHistory4 = new OrderHistory(4L, OrderStatus.DELIVERED, ZonedDateTime.now(), order2);


        OrderHistory orderHistory5 = new OrderHistory(5L, OrderStatus.CREATED, ZonedDateTime.now(), order3);
        OrderHistory orderHistory6 = new OrderHistory(6L, OrderStatus.ACCEPTED, ZonedDateTime.now(), order3);

        OrderHistory orderHistory7 = new OrderHistory(7L, OrderStatus.ACCEPTED, ZonedDateTime.now(), order4);
        OrderHistory orderHistory8 = new OrderHistory(8L, OrderStatus.CREATED, ZonedDateTime.now(), order4);

        OrderHistory orderHistory9 = new OrderHistory(9L, OrderStatus.CREATED, ZonedDateTime.now(), order5);


        orderHistoryRepository.saveAll(Arrays.asList(orderHistory1, orderHistory2, orderHistory3, orderHistory4,
                orderHistory5, orderHistory6, orderHistory7, orderHistory8, orderHistory9));

    }

    private void insertOrderItems() {


        Order order1 = orderRepository.getOne(1L);
        Order order2 = orderRepository.getOne(2L);
        Order order3 = orderRepository.getOne(3L);
        Order order4 = orderRepository.getOne(4L);
        Order order5 = orderRepository.getOne(5L);

        OrderItem orderHistory1 = new OrderItem(1L,  order1, 1L, 20.0, 1);
        OrderItem orderHistory2 = new OrderItem(2L,  order1, 2L, 100.0, 2);
        OrderItem orderHistory3 = new OrderItem(3L,  order2, 3L, 24.0, 5);
        OrderItem orderHistory4 = new OrderItem(4L,  order2, 4L, 80.0, 1);
        OrderItem orderHistory5 = new OrderItem(5L,  order3, 1L, 20.0, 1);
        OrderItem orderHistory6 = new OrderItem(6L,  order3, 2L, 20.0, 1);
        OrderItem orderHistory7 = new OrderItem(7L,  order4, 2L, 60.0, 8);
        OrderItem orderHistory8 = new OrderItem(8L,  order4,3L, 26.0, 3);
        OrderItem orderHistory9 = new OrderItem(9L,  order5, 4L, 9.0, 2);
        OrderItem orderHistory10 = new OrderItem(10L,  order5, 1L, 10.0, 1);


        orderItemRepository.saveAll(Arrays.asList(orderHistory1, orderHistory2, orderHistory3, orderHistory4,
                orderHistory5, orderHistory6, orderHistory7, orderHistory8, orderHistory9, orderHistory10));

    }


}
