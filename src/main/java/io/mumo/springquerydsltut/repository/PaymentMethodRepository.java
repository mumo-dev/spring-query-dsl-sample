package io.mumo.springquerydsltut.repository;

import io.mumo.springquerydsltut.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
