package com.example.BookManagementSystem.service;

import com.example.BookManagementSystem.model.Book;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class CsvReaderService {

    public List<Book> readBooks() throws Exception {

        List<Book> books = new ArrayList<>();

        InputStream inputStream =
                new ClassPathResource("books.csv").getInputStream();

        CSVReader reader =
                new CSVReader(new InputStreamReader(inputStream));

        List<String[]> rows = reader.readAll();

        for(int i = 1; i < rows.size(); i++) {

            String[] row = rows.get(i);

            Book book = new Book(
                    Long.parseLong(row[0]),
                    row[1],
                    row[2],
                    row[3],
                    row[4],
                    Double.parseDouble(row[5]),
                    Integer.parseInt(row[6]),
                    Integer.parseInt(row[7]),
                    row[8],
                    row[9]
            );

            books.add(book);
        }

        return books;
    }
}
