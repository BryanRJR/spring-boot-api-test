package id.bcasyariah.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.bcasyariah.library.payloads.request.BookRequest;
import id.bcasyariah.library.payloads.response.ResponseData;
import id.bcasyariah.library.services.book.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    // /books
    public ResponseEntity<Object> createBook(@RequestBody BookRequest request) {
        try {
            ResponseData responseData = bookService.createBookService(request);
            return ResponseEntity.status(responseData.getStatus()).body(responseData);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<Object> getBooks(@RequestParam(value = "status", defaultValue = "") Boolean status) {
        try {
            ResponseData responseData = bookService.getBooksService(status);
            return ResponseEntity.status(responseData.getStatus()).body(responseData);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/{idBook}")
    public ResponseEntity<Object> getBookById(@PathVariable Long idBook) {
        try {
            ResponseData responseData = bookService.getBookByIdService(idBook);
            return ResponseEntity.status(responseData.getStatus()).body(responseData);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/{idBook}")
    public ResponseEntity<Object> updateBookById(@PathVariable Long idBook, @RequestBody BookRequest request) {
        try {
            ResponseData responseData = bookService.updateBookByIdService(idBook, request);
            return ResponseEntity.status(responseData.getStatus()).body(responseData);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{idBook}")
    public ResponseEntity<Object> deleteBookById(@PathVariable Long idBook) {
        try {
            ResponseData responseData = bookService.deleteBookService(idBook);
            return ResponseEntity.status(responseData.getStatus()).body(responseData);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
