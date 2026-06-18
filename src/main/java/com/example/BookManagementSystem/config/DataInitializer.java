package com.example.BookManagementSystem.config;

import com.example.BookManagementSystem.model.Book;
import com.example.BookManagementSystem.service.CsvReaderService;
import com.example.BookManagementSystem.service.JsonGeneratorService;
import com.example.BookManagementSystem.service.ReportService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final CsvReaderService csvReaderService;
    private final JsonGeneratorService jsonGeneratorService;
    private final ReportService reportService;

    @PostConstruct
    public void init() throws Exception {

        List<Book> books =
                csvReaderService.readBooks();

        jsonGeneratorService.generateJson(books);

        reportService.generateReport();

        System.out.println("JSON Created Successfully");
    }
}
