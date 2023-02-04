package id.bcasyariah.library.services.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mysql.cj.protocol.Message;

import id.bcasyariah.library.models.Book;
import id.bcasyariah.library.payloads.request.BookRequest;
import id.bcasyariah.library.payloads.response.ResponseData;
import id.bcasyariah.library.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    // Instance object
    @Autowired
    BookRepository bookRepository;

    // private Book book = new Book();

    @Override
    public ResponseData createBookService(BookRequest request) {
        // TODO Auto-generated method stub
        // if (request.getJudul() != null && request.getKategori() != null) {

        // }
        String judul = request.getJudul();
        String kategori = request.getKategori();

        Book book = new Book();
        if (request.getJudul() != null) {
            book.setTitle(request.getJudul());
        }
        if (request.getKategori() != null) {
            book.setCategory(request.getKategori());
        }
        if (request.getPenerbit() != null) {
            book.setPublisher(request.getPenerbit());
        }
        if (request.getTahun() != null) {
            book.setYear(request.getTahun());
        }
        if (request.getPengarang() != null) {
            book.setAuthor(request.getPengarang());
        }

        bookRepository.save(book);
        ResponseData responseData = new ResponseData(HttpStatus.CREATED.value(), "Success", book);
        return responseData;
    }

    @Override
    public ResponseData getBooksService(Boolean status) {
        // TODO Auto-generated method stub
        // List<Book> books = bookRepository.findAll();
        List<Book> books;
        if (status == null) {
            books = bookRepository.findAll();
        } else {
            books = bookRepository.findByIsDeleted(status);
        }
        return new ResponseData(HttpStatus.OK.value(), "Success", books);
    }

    @Override
    public ResponseData getBookByIdService(Long idBook) {
        // TODO Auto-generated method stub
        Optional<Book> bookFind = bookRepository.findById(idBook);
        ResponseData responseData;
        if (bookFind.isPresent()) {
            responseData = new ResponseData(HttpStatus.OK.value(), "Success", bookFind.get());
        } else {
            responseData = new ResponseData(HttpStatus.NOT_FOUND.value(), "Not Found", null);

        }
        return responseData;
    }

    @Override
    public ResponseData updateBookByIdService(Long idBook, BookRequest request) {
        // TODO Auto-generated method stub
        // Find book
        Optional<Book> bookFind = bookRepository.findById(idBook);
        ResponseData responseData;

        // validate book
        if (bookFind.isPresent()) {
            Book book = bookFind.get();
            // Update book
            if (request.getJudul() != null) {
                book.setTitle(request.getJudul());
            }
            if (request.getKategori() != null) {
                book.setCategory(request.getKategori());
            }
            if (request.getPenerbit() != null) {
                book.setPublisher(request.getPenerbit());
            }
            if (request.getTahun() != null) {
                book.setYear(request.getTahun());
            }
            if (request.getPengarang() != null) {
                book.setAuthor(request.getPengarang());
            }

            // save to db
            bookRepository.save(book);

            responseData = new ResponseData(200, "Success", book);
        } else {
            responseData = new ResponseData(404, "Not Found", null);
        }

        return responseData;
    }

    @Override
    public ResponseData deleteBookService(Long idBook) {
        // TODO Auto-generated method stub
        Optional<Book> bookFind = bookRepository.findById(idBook);
        ResponseData responseData;
        if (bookFind.isPresent()) {
            Book book = bookFind.get();
            book.setIsDeleted(true);

            // save
            bookRepository.save(book);
            responseData = new ResponseData(200, "Success", book);
        } else {
            responseData = new ResponseData(HttpStatus.NOT_FOUND.value(), "Not Found", null);

        }
        return responseData;
    }

}
