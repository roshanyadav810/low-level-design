package example.librarymanagementsystem.repository;

import example.librarymanagementsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,String> {
}
