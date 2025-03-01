package example.librarymanagementsystem.repository;

import example.librarymanagementsystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {
}
