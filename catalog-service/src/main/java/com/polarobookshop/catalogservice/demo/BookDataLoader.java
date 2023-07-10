package com.polarobookshop.catalogservice.demo;

import com.polarobookshop.catalogservice.domain.Book;
import com.polarobookshop.catalogservice.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("testdata")
public class BookDataLoader {

    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData(){
        bookRepository.deleteAll();
        var book1 = Book.of("1234567891", "Northern Lights",
                "Lyra Silverstar", 9.90, "Somebody");
        var book2 = Book.of("1234567892", "Polar Journey",
                "Iorek Polarson", 12.90, "Somebody1");
        bookRepository.saveAll(List.of(book1, book2));
    }
}
