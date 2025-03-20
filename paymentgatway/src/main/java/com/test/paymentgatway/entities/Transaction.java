package com.test.paymentgatway.entities;

import com.test.paymentgatway.entities.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Currency;
import java.util.UUID;

@Entity
@Table(name = "transactions" , indexes = {
        @Index(name = "user_id_index" , columnList = "user_id"),
        @Index(name = "merchant_id_index" , columnList = "merchant_id"),
        @Index(name = "payment_status_index" , columnList = "status")
})
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    @Column(name = "user_id" , nullable = false)
    private UUID userId;

    @Column(name = "merchant_id" , nullable = false)
    private UUID merchantId;

    @Column(name = "idempotency_key" , nullable = false)
    private String idempotencyKey;

    @Column(name = "amount" , nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    @Column(name = "status" , nullable = false)
    private PaymentStatus status;


    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = Instant.now().getEpochSecond();
        this.updatedAt = Instant.now().getEpochSecond();
    }
    @PreUpdate
    public void preUpdate(){
        this.updatedAt = Instant.now().getEpochSecond();
    }
}
