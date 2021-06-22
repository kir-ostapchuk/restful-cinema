package com.itransition.web.cinema.rest

import com.itransition.web.cinema.model.Movie
import com.itransition.web.cinema.service.MovieService
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
class MovieController(
    private val service: MovieService
) {

    @GetMapping
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