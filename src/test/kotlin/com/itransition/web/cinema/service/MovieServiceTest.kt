package com.itransition.web.cinema.service

import com.itransition.web.cinema.exception.ResourceNotFoundException
import com.itransition.web.cinema.model.Movie
import com.itransition.web.cinema.model.User
import org.junit.jupiter.api.Assertions
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
class MovieServiceTest {

    @MockBean
    private lateinit var movieService: MovieService

    @Test
    fun `Should throw ResourceNotFoundException when finding by id`() {

        // When
        Mockito.`when`(movieService.findOne(100000000)).thenThrow(ResourceNotFoundException::class.java)

        // Verify
        Assertions.assertThrows(ResourceNotFoundException::class.java) { movieService.findOne(100000000) }
    }

    @Test
    fun `Should find movie when finding by id`() {

        //Given
        val movie = Movie(1, "qwerty")

        //When
        Mockito.`when`(movieService.findOne(1)).thenReturn(movie)

        // Verify
        assert(movie == movieService.findOne(1))
    }
}