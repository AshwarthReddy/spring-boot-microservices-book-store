package com.anr.booklistservice.web;

import com.anr.booklistservice.domain.BookDTO;
import com.anr.booklistservice.domain.BookService;
import com.anr.booklistservice.domain.PagedResult;
import com.anr.booklistservice.web.exceptions.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@Slf4j
@RequiredArgsConstructor
class BooksController {
    private final BookService bookService;

    @GetMapping
    PagedResult<BookDTO> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo) {
        log.info("Fetching products for page: {}", pageNo);
        return bookService.getProducts(pageNo);
    }

    @GetMapping("/{code}")
    ResponseEntity<BookDTO> getProductByCode(@PathVariable String code) {
        log.info("Fetching product for code: {}", code);
        return bookService
                .getProductByCode(code)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> BookNotFoundException.forCode(code));
    }
}
