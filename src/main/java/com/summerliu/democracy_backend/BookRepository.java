package com.summerliu.democracy_backend;

import java.util.ArrayList;
import java.util.List;
import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;

public interface BookRepository extends DatastoreRepository<Book, Long> {

    Book findById(String Id);
    ArrayList<String> getChapterList();
}
