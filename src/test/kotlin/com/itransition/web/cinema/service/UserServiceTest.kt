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

    private val user = User(1, "qwerty", "qwerty", "Kirill", 21)

    @Test
    fun `Finding not exist user should throw ResourceNotFoundException`() {
        Mockito.`when`(userService.findOne(100000000)).thenThrow(ResourceNotFoundException::class.java)

        assertThrows(ResourceNotFoundException::class.java) { userService.findOne(100000000) }
    }

    @Test
    fun `Finding exist user`() {
        Mockito.`when`(userService.findOne(1)).thenReturn(user)

        assert(user == userService.findOne(1))
    }
}