package com.example.app.repository;

import com.example.app.domain.Author;
import com.example.app.dto.AuthorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "Select Author.name as name, Author.surname as surname, count(Book.category_id) as quantity, Category.category as category\n" +
            "from Author\n" +
            "left join Authors_Books on Author.id = Authors_Books.author_id\n" +
            "left join Book on Authors_Books.book_id = Book.id\n" +
            "left join Category on Book.category_id = Category.id\n" +
            "group by surname, category", nativeQuery = true)
    List<AuthorDto> getCategoryByCount();
}
