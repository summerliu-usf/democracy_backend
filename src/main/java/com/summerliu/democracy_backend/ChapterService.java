package com.summerliu.democracy_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChapterService {

    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private BookService bookService;

    public List<Chapter> getChaptersForBook(String bookId) {
        Book book = bookService.getBookById(bookId);
        if (book != null) {
            return book.getChapters();
        }
        return List.of();
    }

    public Optional<Chapter> getChapterById(String bookId, int chapterNumber) {
        Book book = bookService.getBookById(bookId);
        if (book != null) {
            return book.getChapters().stream()
                    .filter(chapter -> chapter.getId() == chapterNumber)
                    .findFirst();
        }
        return Optional.empty();
    }

    public Chapter saveChapter(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    public void deleteChapter(String chapterId) {
        chapterRepository.deleteById(chapterId);
    }
}
