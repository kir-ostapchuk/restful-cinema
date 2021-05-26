package com.itransition.web.cinema

import com.itransition.web.cinema.model.User
import com.itransition.web.cinema.service.UserService
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var userService: UserService

    @Test
    fun `Should add user`() {

        // Given
        val user = User(1, "qjnzero", "lolpassword", "Kirill", 21)
        val jsonBody = """
            {
                "login": "qjnzero",
                "password": "lolpassword",
                "firstName": "Kirill",
                "age": 21
            }
        """.trimIndent()

        // When
        Mockito.`when`(userService.save(any())).thenReturn(user)

        // Verify
        mockMvc.perform(
            post("/api/v1/users")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$.login").value("qjnzero"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("lolpassword"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Kirill"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(21))
    }

    @Test
    fun `Should not add user when add user with empty login and password`() {

        // Given
        val jsonBody = """
            {
                "login": "",
                "password": "",
                "firstName": "Vasya",
                "age": 14
            }
        """.trimIndent()

        // Verify
        mockMvc.perform(
            post("/api/v1/users")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isBadRequest)
    }

    @Test
    fun `Should return user`() {

        // Given
        val user = User(1, "qjnzero", "lolpassword", "Kirill", 21)

        // When
        Mockito.`when`(userService.findOne(1)).thenReturn(user)

        // Verify
        mockMvc.perform(get("/api/v1/users/1"))
            .andExpect(status().isOk)
            .andExpect(content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$.login").value("qjnzero"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("lolpassword"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Kirill"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(21))
    }

    @Test
    fun `Should return empty list`() {

        // Verify
        mockMvc.perform(get("/api/v1/users"))
            .andExpect(status().isOk)
            .andExpect(content().json("[]", true))
    }

    @Test
    fun `Should return list of users`() {

        // Given
        val user1 = User(1, "qjnzero", "lolpassword", "Kirill", 21)
        val user2 = User(2, "qjnzeroFAKE", "lolpasswordFAKEABLE", "Vasya", 41)
        val users = listOf(user1, user2)

        // When
        Mockito.`when`(userService.findAll()).thenReturn(users)

        // Verify
        mockMvc.perform(get("/api/v1/users"))
            .andExpect(status().isOk)
            .andExpect(content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].login").value("qjnzero"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].password").value("lolpassword"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("Kirill"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].age").value(21))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].login").value("qjnzeroFAKE"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].password").value("lolpasswordFAKEABLE"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].firstName").value("Vasya"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].age").value(41))
    }

    @Test
    fun `Should delete user`() {

        // Verify
        mockMvc.perform(delete("/api/v1/users/1"))
            .andExpect(status().isOk)
    }
}