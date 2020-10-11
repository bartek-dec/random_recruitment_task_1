package com.example.app.controller;

import com.example.app.dto.AuthorTransfer;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class AuthorController {

    @GetMapping("/")
    public String index(Model model) {
        RestTemplate template = new RestTemplate();

        ResponseEntity<AuthorTransfer[]> responseEntity = template.exchange("http://localhost:8080/api/authors",
                HttpMethod.GET,
                null,
                AuthorTransfer[].class);

        model.addAttribute("authors", responseEntity.getBody());

        return "index";
    }
}
