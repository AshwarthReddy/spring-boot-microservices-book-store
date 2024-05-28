package com.anr.booklistservice.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface BookRepo extends JpaRepository<Book, Long> {
    Optional<Book> findByCode(String code);
}
