package com.itransition.web.cinema

import com.itransition.web.cinema.model.Movie
import com.itransition.web.cinema.service.MovieService
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTests {

    // TODO(
    //  Replace crazy code:
    //  4. add comments
    //  5. remove string-json
    //  6. add comparing json with
    //  7. test all cases (non-valid name, resource does not exist)
    //  )

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var movieService: MovieService

    @Test
    fun `Should return empty list`() {

        // Verify
        mockMvc.perform(get("/api/v1/movies"))
            .andExpect(status().is2xxSuccessful)
            .andExpect(content().json("[]", true)) // TODO(remove .json method usage)
    }

    @Test
    fun `Should add movie`() {

        //Given
        val movie = Movie(1, "Independent")
        val jsonBody = """
            {
                "name": "Independent"
            }
        """.trimIndent()

        //When
        Mockito.doReturn(movie).`when`(movieService).save(any())

        // Verify
        mockMvc.perform(post("/api/v1/movies")
            .content(jsonBody)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("Independent"))
    }

    @Test
    fun `Should return movie`() {

        //Given
        val movie = Movie(1, "Independent")

        //When
        Mockito.`when`(movieService.findOne(1)).thenReturn(movie)

        //Verify
        mockMvc.perform(get("/api/v1/movies/1"))
            .andExpect(status().is2xxSuccessful)
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("Independent"))
    }

    @Test
    fun `Should return list of movies`() {

        //Given
        val movie1 = Movie(1, "Independent")
        val movie2 = Movie(2, "BelarusRWR")
        val movies = listOf(movie1, movie2)

        //When
        Mockito.`when`(movieService.findAll()).thenReturn(movies)

        //Verify
        mockMvc.perform(get("/api/v1/movies"))
            .andExpect(status().is2xxSuccessful)
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].name").value("Independent"))
            .andExpect(jsonPath("$[1].id").value(2))
            .andExpect(jsonPath("$[1].name").value("BelarusRWR"))
    }

    @Test
    fun `Should delete movie`() {

        // Verify
        mockMvc.perform(delete("/api/v1/movies/1"))
            .andExpect(status().isOk)
    }

}
