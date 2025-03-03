package example.librarymanagementsystem.route;

import example.librarymanagementsystem.entity.Book;
import example.librarymanagementsystem.service.IBook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final IBook bookService;

    public BookController(IBook book) {
        this.bookService = book;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @RequestMapping(path = "/{bookId}", method = RequestMethod.GET)
    public ResponseEntity<Book> getBook(@PathVariable String bookId){
        return ResponseEntity.ok(bookService.getBook(bookId));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getAllBook(){
        return ResponseEntity.ok(bookService.getAllBook());
    }

}
