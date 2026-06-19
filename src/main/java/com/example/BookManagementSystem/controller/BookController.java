package com.example.BookManagementSystem.controller;

import com.example.BookManagementSystem.model.Book;
import com.example.BookManagementSystem.service.JsonReaderService;
import com.example.BookManagementSystem.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final JsonReaderService jsonReaderService;
    private final ReportService reportService;

    @GetMapping
    public Object getAllBooks() {

        List<Book> books =
                jsonReaderService.readJson();

        if (books.isEmpty()) {

            return Map.of(
                    "message",
                    "No books available."
            );
        }

        return books;
    }

    @GetMapping("/reports")
    public String getReport() {

        try {

            reportService.generateReport();

            Path reportPath =
                    Path.of("report.txt");

            if (!Files.exists(reportPath)) {

                return "Report file not found.";
            }

            return Files.readString(reportPath);

        } catch (Exception ex) {

            return "Unable to generate report.";
        }
    }
}