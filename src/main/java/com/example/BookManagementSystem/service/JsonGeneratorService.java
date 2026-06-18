package com.example.BookManagementSystem.service;

import com.example.BookManagementSystem.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class JsonGeneratorService {

    public void generateJson(List<Book> books) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(
                        new File("books.json"),
                        books
                );
    }
}