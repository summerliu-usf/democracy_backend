package com.summerliu.democracy_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/{bookId}/chapters")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;
    private ChatService chatService;

    @GetMapping
    public List<Chapter> getChaptersForBook(@PathVariable String bookId) {
        return chapterService.getChaptersForBook(bookId);
    }

    @GetMapping("/chapter_{chapterId}")
    public Chapter getChapterById(@PathVariable String bookId, @PathVariable int chapterId) {
        return chapterService.getChapterById(bookId, chapterId)
                .orElseThrow(() -> new IllegalArgumentException("Chapter not found"));
    }

    @PostMapping("/chapter_{chapterId}/chat/send")
    public String chatAboutChapter(@PathVariable int chapterId, @RequestParam String message) {
        String context = "You are discussing chapter" + chapterId;
        return chatService.sendMessage(context, message);
    }

    @GetMapping("/{chapterId}/chat/sampleQuestions")
    public List<String> generateSampleQuestionsForChapter(
            @PathVariable int chapterId,
            @RequestParam int count,
            @RequestParam int maxWords) {
        String context = "Generate questions about chapter" + chapterId;
        return chatService.generateSampleQuestions(context, count, maxWords);
    }
}
