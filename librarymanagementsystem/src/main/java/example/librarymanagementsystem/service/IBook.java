package example.librarymanagementsystem.service;

import example.librarymanagementsystem.entity.Book;

import java.util.List;
import java.util.Optional;

public interface IBook {
    Book addBook(Book book);
    Book getBook(String id);
    List<Book> getAllBook();
    List<Book> searchBook(Optional<String> title , Optional<String> description , Optional<String> authorName, int pageNumber , int pageSize);
}
