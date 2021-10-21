package com.filmes.com.filmes.controller;

import com.filmes.flavio.filmes.controller.FilmeController;
import com.filmes.flavio.filmes.service.FilmeService;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;


@WebMvcTest
public class FilmeControllerTest {

    @Autowired
    private FilmeController filmeController;

    @MockBean
    private FilmeService filmeService;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.filmeController);
    }

    @Test
    public void deveRetornarSucesso_QuandoBuscarFilme() {

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/filmes/{codigo}", 1L)
                .then()
                .statusCode(HttpStatus.OK.value());


    }

}
