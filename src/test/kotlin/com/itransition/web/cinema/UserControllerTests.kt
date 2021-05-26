package com.itransition.web.cinema

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup
import org.springframework.web.context.WebApplicationContext

@SpringBootTest
@TestMethodOrder(
    MethodOrderer.OrderAnnotation::class)
class UserControllerTests {

    // TODO(
    //  Replace crazy code:
    //  4. add comments
    //  5. remove string-json
    //  6. add comparing json with
    //  7. test all cases (non-valid name, resource does not exist)
    //  )

    private val baseUrl = "http://localhost:8080/api/v1/users"
    private val jsonContentType = MediaType(MediaType.APPLICATION_JSON.type, MediaType.APPLICATION_JSON.subtype)
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var webAppContext: WebApplicationContext

    @BeforeEach
    fun before() {
        mockMvc = webAppContextSetup(webAppContext).build();
    }

    @Test
    @Order(1)
    fun `1 - Get empty list of users`() {
        val request = get(baseUrl).contentType(jsonContentType)

        mockMvc.perform(request)
            .andExpect(status().is2xxSuccessful)
            .andExpect(content().json("[]", true))
    }

    @Test
    @Order(2)
    fun `2 - Add first user`() {
        val passedJsonString = """
            {
                "login": "xfaseex",
                "password": "TestPassword",
                "firstName": "Kirill",
                "age": 19
            }
        """.trimIndent()

        val request = post(baseUrl).contentType(jsonContentType).content(passedJsonString)

        val resultJsonString = """
            {
                "id": 1,
                "login": "xfaseex",
                "password": "TestPassword",
                "firstName": "Kirill",
                "age": 19
            }
        """.trimIndent()

        mockMvc.perform(request)
            .andExpect(status().is2xxSuccessful)
            .andExpect(content().json(resultJsonString, true))
    }

    @Test
    @Order(3)
    fun `3 - Get first movie`() {
        val request = get("$baseUrl/1").contentType(jsonContentType)

        val resultJsonString = """
            {
                "id": 1,
                "login": "xfaseex",
                "password": "TestPassword",
                "firstName": "Kirill",
                "age": 19
            }
        """.trimIndent()

        mockMvc.perform(request)
            .andExpect(status().is2xxSuccessful)
            .andExpect(content().json(resultJsonString, true))
    }

    @Test
    @Order(4)
    fun `4 - Get list of movies, with one movie`() {
        val request = get(baseUrl).contentType(jsonContentType)

        val resultJsonString = """
            [
                {
                    "id": 1,
                    "login": "xfaseex",
                    "password": "TestPassword",
                    "firstName": "Kirill",
                    "age": 19
                }
            ]
        """.trimIndent()

        mockMvc.perform(request)
            .andExpect(status().isOk)
            .andExpect(content().json(resultJsonString, true))
    }

    @Test
    @Order(5)
    fun `5 - Delete first movie`() {
        val request = delete("$baseUrl/1").contentType(jsonContentType)

        mockMvc.perform(request).andExpect(status().isOk)
    }

}