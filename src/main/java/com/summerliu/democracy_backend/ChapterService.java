package com.summerliu.democracy_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChapterService {
    @Autowired
    private ChapterRepository chapterRepository;

    public Optional<Chapter> getChapterById(String bookId, int chapId) {

    }

}
