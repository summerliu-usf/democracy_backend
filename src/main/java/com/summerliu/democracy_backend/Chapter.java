package com.summerliu.democracy_backend;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

@Entity(name = "Chapter") // Maps to the "Chapter" kind in Datastore
public class Chapter {
    @Id
    private int id; // Unique identifier for the chapter
    private String title; // Chapter title
    private String podcastUrl; // URL to the podcast of the chapter
    private String bookId; // Foreign key linking to the book this chapter belongs to
    private ChapterRepository chapterRepository;
    // Constructors
    public Chapter() {}


    public Chapter(int id, String title, String podcastUrl, String bookId) {
        this.id = id;
        this.title = title;
        this.podcastUrl = podcastUrl;
        this.bookId = bookId;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPodcastUrl() {
        return podcastUrl;
    }

    public void setPodcastUrl(String podcastUrl) {
        this.podcastUrl = podcastUrl;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
