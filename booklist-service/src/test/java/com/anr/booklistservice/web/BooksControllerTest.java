package com.anr.booklistservice.web;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import com.anr.booklistservice.AbstractIT;
import com.anr.booklistservice.domain.BookDTO;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;

@Sql("/test-data.sql")
class BooksControllerTest extends AbstractIT {

    @Test
    void shouldReturnProducts() {
        given().contentType(ContentType.JSON)
                .with()
                .get("/api/books")
                .then()
                .statusCode(200)
                .body("data", hasSize(10))
                .body("totalElements", is(15))
                .body("pageNumber", is(1))
                .body("totalPages", is(2))
                .body("isFirst", is(true))
                .body("isLast", is(false))
                .body("hasNext", is(true))
                .body("hasPrevious", is(false));
    }

        @Test
        void shouldGetProductByCode() {

            BookDTO p100 = given().contentType(ContentType.JSON)
                    .with()
                    .get("/api/books/{code}", "P100")
                    .then()
                    .statusCode(200)
                    .assertThat()
                    .extract()
                    .body()
                    .as(BookDTO.class);

            assertThat(p100.code()).isEqualTo("P100");
            assertThat(p100.name()).isEqualTo("The Hunger Games");
            assertThat(p100.description()).isEqualTo("Winning will make you famous. Losing means certain death...");
            assertThat(p100.price()).isEqualTo(new BigDecimal("34.0"));
        }

        @Test
        void shouldReturnNotFoundWhenProductCodeNotExists() {
            String code = "invalid_product_code";
            given().contentType(ContentType.JSON)
                    .when()
                    .get("/api/books/{code}", code)
                    .then()
                    .statusCode(404)
                    .body("status", is(404))
                    .body("title", is("Product Not Found"))
                    .body("detail", is("Product with code " + code + " not found"));
        }
}
