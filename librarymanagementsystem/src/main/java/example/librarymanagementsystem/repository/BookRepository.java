package example.librarymanagementsystem.repository;

import example.librarymanagementsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,String> {
    @Query("select b from Book b where b.title like concat('%', ?1, '%') or b.description like concat('%', ?2, '%')")
    List<Book> findByTitleContainingOrDescriptionContaining(String title, String description);
}
