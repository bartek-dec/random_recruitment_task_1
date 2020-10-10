package com.example.app.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Table(name = "author")
public class Author extends AbstractEntity<Long> {

    @ToString.Include
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ToString.Include
    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "authors_books",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private List<Book> books = new ArrayList<>();
}
