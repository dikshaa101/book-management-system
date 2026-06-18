package com.example.BookManagementSystem.controller;

import com.example.BookManagementSystem.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final ReportService reportService;

    @GetMapping("/reports")
    public String getReport() throws Exception {

        reportService.generateReport();

        return Files.readString(
                Path.of("report.txt")
        );
    }
}