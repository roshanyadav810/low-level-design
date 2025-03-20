package com.test.paymentgatway.repositories;

import com.test.paymentgatway.entities.Refund;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RefundRepository extends JpaRepository<Refund, UUID> {
}
