package com.example.BookManagementSystem.service;

import com.example.BookManagementSystem.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Service
public class JsonReaderService {

    public List<Book> readJson() {

        try {

            File file =
                    new File("books.json");

            if (!file.exists()) {

                return List.of();
            }

            ObjectMapper mapper =
                    new ObjectMapper();

            return Arrays.asList(
                    mapper.readValue(
                            file,
                            Book[].class
                    )
            );

        } catch (Exception ex) {

            return List.of();
        }
    }
}