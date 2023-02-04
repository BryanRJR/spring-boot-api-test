package id.bcasyariah.library.services.book;

import id.bcasyariah.library.payloads.request.BookRequest;
import id.bcasyariah.library.payloads.response.ResponseData;

public interface BookService {
    // Kerangka methods CRUD
    // Create Book
    ResponseData createBookService(BookRequest request);

    // Read Book
    ResponseData getBooksService(Boolean status);

    ResponseData getBookByIdService(Long idBook);

    // Update
    ResponseData updateBookByIdService(Long idBook, BookRequest request);

    // Delete
    ResponseData deleteBookService(Long idBook);

}
