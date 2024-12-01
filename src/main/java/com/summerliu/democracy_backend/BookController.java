package com.summerliu.democracy_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ChapterService chapterService;

    // Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Get chapters of a specific book
    @GetMapping("/{bookId}/chapters")
    public List<Chapter> getChaptersForBook(@PathVariable String bookId) {
        return bookService.getChaptersById(bookId);
    }

    // Get a specific chapter of a book
    @GetMapping("/{bookId}/chapters/{chapterId}")
    public Optional<Chapter> getSpecificChapter(
            @PathVariable String bookId,
            @PathVariable int chapterId) {
        // Optional: Verify the chapter belongs to the book
        Optional<Chapter> chapter = chapterService.getChapterById(bookId, chapterId);
        if (chapter.isPresent() && !chapter.get().getBookId().equals(bookId)) {
            throw new IllegalArgumentException("Chapter does not belong to the specified book");
        }
        return chapter;
    }
}
