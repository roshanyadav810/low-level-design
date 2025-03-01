package example.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "order_details")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private List<Book> bookList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id",referencedColumnName = "id")
    private Payment payment;

}
