package example.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    @Column(nullable = false)
    private String name;

    @Column(name = "created_at")
    private Long createdAt;

    @PrePersist
    void addCreatedAt(){
        this.createdAt = Instant.now().getEpochSecond();
    }


}
