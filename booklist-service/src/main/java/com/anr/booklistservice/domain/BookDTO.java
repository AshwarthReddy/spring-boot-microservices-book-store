package com.anr.booklistservice.domain;

import java.math.BigDecimal;

public record BookDTO(String code, String name, String description, String imageUrl, BigDecimal price) {}
