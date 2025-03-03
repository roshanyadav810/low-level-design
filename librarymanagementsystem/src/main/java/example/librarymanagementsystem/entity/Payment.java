package example.librarymanagementsystem.entity;

import example.librarymanagementsystem.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "amount",nullable = false)
    private Double amount;

    @Column(name = "payment_method",nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @OneToOne(mappedBy = "payment")
    private Order order;

    @Column(name = "created_at")
    private Long createdAt;

    @PrePersist
    void addCreatedAt(){
        this.createdAt = Instant.now().getEpochSecond();
    }

}
