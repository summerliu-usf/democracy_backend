package com.summerliu.democracy_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chapters") // Base path for chapter-related endpoints
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    // Get a specific chapter by ID
    @GetMapping("/Chapter{id}")
    public Optional<Chapter> getChapterById(@PathVariable int id) {
        return chapterService.getChapterById(id);
    }

}
