package com.example.app;

import com.example.app.domain.Author;
import com.example.app.domain.Book;
import com.example.app.domain.Category;

import com.example.app.domain.CategoryEnum;
import com.example.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class InitService {

    private BookRepository bookRepository;

    @Autowired
    public InitService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void initDatabase() {

        Category fiction = Category.builder().category(CategoryEnum.FICTION).build();
        Category mystery = Category.builder().category(CategoryEnum.MYSTERY).build();
        Category romance = Category.builder().category(CategoryEnum.ROMANCE).build();



        Author tolkien = Author.builder().name("J.R.R.").surname("Tolkien").build();
        Author lee = Author.builder().name("Christopher").surname("Lee").build();
        Author shephard = Author.builder().name("Joel").surname("Shephard").build();
        Author ward = Author.builder().name("J.R.").surname("Ward").build();

        Book book1 = Book.builder()
                .ISBN("B0099SNV7I")
                .title("The Hobbit ")
                .category(fiction)
                .authors(Stream.of(tolkien).collect(Collectors.toList()))
                .build();

        Book book2 = Book.builder()
                .ISBN("B000WM9UK2")
                .title("The Children of Hurin")
                .category(fiction)
                .authors(Stream.of(tolkien, lee).collect(Collectors.toList()))
                .build();

        Book book3 = Book.builder()
                .ISBN("B014G9ULWW")
                .title("Renegade: Spiral Wars")
                .category(mystery)
                .authors(Stream.of(lee, shephard).collect(Collectors.toList()))
                .build();

        Book book4 = Book.builder()
                .ISBN("1982143525")
                .title("Prisoner of Night")
                .category(romance)
                .authors(Stream.of(ward).collect(Collectors.toList()))
                .build();

        Book book5 = Book.builder()
                .ISBN("1982132108")
                .title("The Sinner")
                .category(romance)
                .authors(Stream.of(ward).collect(Collectors.toList()))
                .build();

        bookRepository.saveAll(Stream.of(book1, book2, book3, book4, book5).collect(Collectors.toList()));
    }

}
