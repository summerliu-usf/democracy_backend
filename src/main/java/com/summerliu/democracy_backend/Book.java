package com.summerliu.democracy_backend;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity(name = "Book") // Maps to the "Book" kind in Datastore
public class Book {
    @Id
    private String id; // Unique identifier for the book
    private String title; // Book title
    private String description; // Brief description of the book
    private String coverImageUrl; // URL to the book's cover image
    private ArrayList<Chapter> chapterList;
    private ChapterRepository chapterRepository;

    // Constructors
    public Book() {}

    public Book(String id, String title, String description, String coverImageUrl, String chapterList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.coverImageUrl = coverImageUrl;
        this.chapterList = addAllChapters(chapterList);
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public ArrayList<Chapter> getChapterList(){
        return this.chapterList;
    }

    public ArrayList<Chapter> addAllChapters(String lstOfChapters) {
        // Create and save the chapter instance
        int chapId = 1;
        String[] result = lstOfChapters.split(";");
        List<String> lst = Arrays.asList(result);
        ArrayList<Chapter> res = new ArrayList<>();
        for (String title: lst){
            Chapter chapter = new Chapter();
            chapter.setBookId(this.id);
            chapter.setTitle(title);
            chapter.setId(chapId);
            chapterRepository.save(chapter);
            res.add(chapter);
            chapId++;
        }
        return res;
    }

    public ArrayList<Chapter> getChapters() {
        return this.chapterList;
    }

    public ArrayList<String> getChapterTitles() {
        ArrayList<String> lst = new ArrayList<>();
        for (Chapter chapter: chapterList) {
            lst.add(chapter.getTitle());
        }
        return lst;
    }
}
