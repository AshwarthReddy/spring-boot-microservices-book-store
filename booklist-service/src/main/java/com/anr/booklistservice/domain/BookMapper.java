package com.anr.booklistservice.domain;

public class BookMapper {

    static BookDTO toProduct(Book productEntity) {
        return new BookDTO(
                productEntity.getCode(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getImageUrl(),
                productEntity.getPrice());
    }
}
