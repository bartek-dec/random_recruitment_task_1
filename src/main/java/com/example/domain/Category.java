package com.example.domain;

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
@Table(name = "category")
public class Category extends AbstractEntity<Long> {

    @ToString.Include
    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private CategoryEnum category;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Book> books = new ArrayList<>();
}
