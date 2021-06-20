package com.example.kotlinwebdemo.controller

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class HtmlControllerTest(
    @Autowired val restTemplate: TestRestTemplate
) {
    @BeforeAll
    fun init() {
        println(">>> Before All")
    }

    @Test
    fun `get content successful`() {
        // given
        val expectedValue = "Hello World"
        val expectedCode = 200

        // when
        val actualResult = restTemplate.getForEntity("/home", String::class.java)

        // then
        assertEquals(expectedValue, actualResult.body)
        assertEquals(expectedCode, actualResult.statusCode.value())
    }

    @Test
    fun `todo list equals`() {
        println("todo list equals")
    }

    @AfterAll
    fun endUp() {
        println(">>> After All")
    }
}