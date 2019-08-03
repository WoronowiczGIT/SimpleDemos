package com.example.internetshop.demoService;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

    //Rest cechuje to ze odpowiedzi bezstanowe które zwracaja JSONa
    private static List<Book> books = new ArrayList<>();

    // klasa wyspecjalizowana w byciu counterem
    private static AtomicInteger counter = new AtomicInteger(1);

    // servlett = controller , servlett przyslania metody http
    @GetMapping(value="/all")
    public List<Book> test(){
        return books;
    }

    @PostMapping
    public void saveBook(@Valid @RequestBody CreateBookDto createBookDto){
        Book book = Book.builder()
                .author(createBookDto.getAuthor())
                .title(createBookDto.getTitle())
                .year(createBookDto.getYear())
                .id(counter.getAndIncrement())
                .type(createBookDto.getType())
                .build();

        books.add(book);
    }
    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable Integer bookId){
        return books.stream().filter(book -> book.getId().equals(bookId))
                .findAny()
                .orElse(null);
    }
    // request param -> we Add to path

    @GetMapping
    public List<Book> booksWithType(@RequestParam(defaultValue = "HORROR" )Type type ){
        return books.stream().filter(b->b.getType().equals(type))
                .collect(Collectors.toList());
    }

    private void ptintTest(){
        System.out.println("hello world");
        // if return String -> zwroci string w odpowiedzi

    }

    private Book getBook(){
        return Book.builder()
                .author("coehlo")
                .title("tytul ksiazki")
                .year(1990)
                .build();
    }


}

