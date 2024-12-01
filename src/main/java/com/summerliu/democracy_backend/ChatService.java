
package com.summerliu.democracy_backend;

import org.springframework.stereotype.Service;

@Service
public class ChatService {

    public String getMessagesForChapter(String response) {
        // Gets chat response from ai
        return response;
    }

    public String sendMessageToChat(String chapterId, String message) {
        // send chat messages
        return message;
    }
}
