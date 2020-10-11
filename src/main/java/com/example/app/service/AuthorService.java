package com.example.app.service;

import com.example.app.dto.AuthorDto;
import com.example.app.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository repository;

    @Autowired
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<AuthorDto> getCategoryByCount() {
        return repository.getCategoryByCount();
    }
}
