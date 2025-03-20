package com.test.paymentgatway.entities;

import com.test.paymentgatway.entities.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Currency;
import java.util.UUID;

@Entity
@Table(name = "refunds",indexes = {
        @Index(name = "transaction_id_index" , columnList = "transaction_id"),
})
@Data
@Builder
public class Refund {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    @Column(name = "transaction_id" , nullable = false)
    private UUID transactionId;

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
