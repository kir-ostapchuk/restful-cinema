package com.itransition.web.cinema.service

import com.itransition.web.cinema.exception.ResourceNotFoundException
import com.itransition.web.cinema.model.User
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
@ExtendWith(
    MockitoExtension::class
)
class UserServiceTest {

    @MockBean
    private lateinit var userService: UserService

    @Test
    fun `Should throw ResourceNotFoundException when finding by id`() {

        // When
        Mockito.`when`(userService.findOne(100000000)).thenThrow(ResourceNotFoundException::class.java)

        // Verify
        assertThrows(ResourceNotFoundException::class.java) { userService.findOne(100000000) }
    }

    @Test
    fun `Should find user when finding by id`() {

        // Given
        val user = User(1, "qwerty", "qwerty", "Kirill", 21)

        // When
        Mockito.`when`(userService.findOne(1)).thenReturn(user)

        // Verify
        assert(user == userService.findOne(1))
    }
}