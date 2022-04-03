package com.example.emt_lab2.web;

import com.example.emt_lab2.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoriesRestController {

    @GetMapping
    public List<Category> getCategories()
    {
        return List.of(Category.values());
    }
}
