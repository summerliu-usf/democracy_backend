package com.summerliu.democracy_backend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.summerliu.democracy_backend.Chapter;
import com.summerliu.democracy_backend.ChapterService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ChapterService chapterService; // Use ChapterService here

    public Book addBook(String title, String coverImageUrl, String chapterList) {
        // Create and save the book instance
        Book book = new Book();
        book.setTitle(title);
        book.setCoverImageUrl(coverImageUrl);
        book.addAllChapters(chapterList);
        return bookRepository.save(book);
    }

    // Get all books
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    // Get a specific book by ID
    public Book getBookById(String id) {
        return bookRepository.findById(id);
    }

    // Get chapters for a specific book
    public List<String> getChaptersForBook(String bookId) {
        return bookRepository.getChapterList();
    }

    // Add or update a book
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

}