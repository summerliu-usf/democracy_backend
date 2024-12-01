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

    @GetMapping
    public List<Chapter> getChaptersForBook(@PathVariable String bookId) {
        return chapterService.getChaptersForBook(bookId);
    }

    @GetMapping("/chapter_{chapterNumber}")
    public Chapter getChapterById(@PathVariable String bookId, @PathVariable int chapterNumber) {
        return chapterService.getChapterById(bookId, chapterNumber)
                .orElseThrow(() -> new IllegalArgumentException("Chapter not found"));
    }

    @RequestMapping("/chat")
    public class ChatController {

        @Autowired
        private ChatService chatService;

        @GetMapping("/{chapterId}")
        public List<Message> getChatMessages(@PathVariable String chapterId) {
            return chatService.getMessagesForChapter(chapterId);
        }

        @PostMapping("/{chapterId}/send")
        public Message sendMessage(@PathVariable String chapterId, @RequestBody ChatMessage message) {
            return chatService.sendMessageToChat(chapterId, message);
        }
    }

}
