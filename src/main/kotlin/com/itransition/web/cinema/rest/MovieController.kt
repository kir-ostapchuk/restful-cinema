package com.itransition.web.cinema.rest

import com.itransition.web.cinema.model.Movie
import com.itransition.web.cinema.service.MovieService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import javax.validation.Valid
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = ["http://localhost:3030"])
@Tag(name = "Movies", description = "Available endpoints in Movie Controller")
class MovieController(
    private val service: MovieService
) {

    @Operation(
        summary = "Gets all the movies.",
        description = "Retrieves all the movies from **DB**.",
        operationId = "findAllMovies"
    )
    @ApiResponses(value = [
        ApiResponse(
            responseCode = "200", description = "Successful operation",
            content = [Content(array = ArraySchema(schema = Schema(implementation = Movie::class)))]
        ),
        ApiResponse(
            responseCode = "404", description = "Movies not found"
        )
    ])
    @GetMapping(value = ["/"], produces = ["application/json"])
    fun findAll(): List<Movie> = service.findAll()

    @GetMapping("/{id}")
    fun findOne(@PathVariable("id") id: Long): Movie =
        service.findOne(id)

    @PostMapping
    fun save(@Valid @RequestBody movie: Movie): Movie =
        service.save(movie)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) {
        service.deleteById(id)
    }

    @GetMapping("/findByName/{name}")
    fun findOneByName(@PathVariable("name") name: String): Movie =
        service.findByName(name)
}