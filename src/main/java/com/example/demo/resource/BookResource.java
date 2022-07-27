package com.example.demo.resource;

import com.example.demo.model.Book;
import com.example.demo.model.Response;
import com.example.demo.service.implementation.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookResource {
    private final BookServiceImpl bookService;

    @GetMapping("/list")
    public ResponseEntity<Response> getBook(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("books", bookService.list(30)))
                        .message("Book retrived")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @PostMapping("/save")
    public ResponseEntity<Response> saveBook(@RequestBody @Valid Book book){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("books", bookService.create(book)))
                        .message("Book created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Response> deleteBook(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", bookService.delete(id)))
                        .message("Book deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getBook(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("book", bookService.get(id)))
                        .message("Book retrived")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping(path = "/image/{fileName}", produces = IMAGE_PNG_VALUE)
    public byte[] getBookImage(@PathVariable("fileName") String fileName) throws IOException {
        Resource resource = new ClassPathResource("image/" + fileName);
        InputStream input = resource.getInputStream();
        return input.readAllBytes();    }

//    @GetMapping(path = "/image", produces = IMAGE_PNG_VALUE)
//    public byte[] getBookImage() throws IOException {
//        Resource resource = new ClassPathResource("image/book2.png");
//        InputStream input = resource.getInputStream();
//        return input.readAllBytes();
//    }

}
