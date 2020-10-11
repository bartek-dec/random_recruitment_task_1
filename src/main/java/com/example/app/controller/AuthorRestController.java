package com.example.app.controller;

import com.example.app.dto.AuthorDto;
import com.example.app.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorRestController {

    private AuthorService service;

    @Autowired
    public AuthorRestController(AuthorService service) {
        this.service = service;
    }

    @GetMapping("/api/authors")
    public ResponseEntity<List<AuthorDto>> getAuthors() {
        List<AuthorDto> authors = service.getCategoryByCount();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }
}
