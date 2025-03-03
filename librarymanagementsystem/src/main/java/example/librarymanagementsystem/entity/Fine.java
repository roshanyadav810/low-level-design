package example.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
@Table(name = "fine")
public class Fine {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    private double amount=0.0;

    @Column(name = "created_at")
    private Long createdAt;

    @PrePersist
    void addCreatedAt(){
        this.createdAt = Instant.now().getEpochSecond();
    }

}
