package com.test.paymentgatway.entities;

import com.test.paymentgatway.entities.enums.UserStatus;
import com.test.paymentgatway.entities.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "users"
        , uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")}
        ,indexes = { @Index(name = "email_index", columnList = "email")
, @Index(name = "status_index", columnList = "status")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false ,length = 100, unique = true)
    private String email;

    @Column(nullable = false , length = 200)
    private String name;

    @Column(nullable = false , length = 20)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType type;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;


}
