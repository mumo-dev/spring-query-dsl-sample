package io.mumo.springquerydsltut.repository;

import io.mumo.springquerydsltut.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
