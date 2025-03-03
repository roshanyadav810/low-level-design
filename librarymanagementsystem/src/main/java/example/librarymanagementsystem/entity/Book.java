package example.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "title" , nullable = false , unique = true)
    private String title;

    @Column(name = "description" , nullable = false , columnDefinition = "TEXT")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_author_mapping",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private Set<Author> authorList;

    @Column(name = "quantity")
    private int quantity = 0;

    @Column(name = "created_at")
    private Long createdAt;

    @PrePersist
    void addCreatedAt(){
        this.createdAt = Instant.now().getEpochSecond();
    }

}
