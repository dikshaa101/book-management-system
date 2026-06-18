package com.example.BookManagementSystem.service;

import com.example.BookManagementSystem.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Service
public class JsonReaderService {

    public List<Book> readJson() throws Exception {

        ObjectMapper mapper =
                new ObjectMapper();

        return Arrays.asList(
                mapper.readValue(
                        new File("books.json"),
                        Book[].class
                )
        );
    }
}