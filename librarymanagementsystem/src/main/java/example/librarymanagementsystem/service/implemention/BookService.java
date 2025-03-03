package example.librarymanagementsystem.service.implemention;

import example.librarymanagementsystem.entity.Book;
import example.librarymanagementsystem.repository.BookRepository;
import example.librarymanagementsystem.service.IBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Repository
@Slf4j
public class BookService implements IBook {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book getBook(String id) {
        Optional<Book> bookOptional= bookRepository.findById(id);
        if(bookOptional.isEmpty()){
            throw new RuntimeException("Book not found ");
        }
        return bookOptional.get();
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchBook(Optional<String> title, Optional<String> description, Optional<String> authorName, int pageNumber, int pageSize) {
        return List.of();
    }
}
