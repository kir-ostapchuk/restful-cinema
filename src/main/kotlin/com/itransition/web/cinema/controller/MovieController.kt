package com.itransition.web.cinema.controller

import com.itransition.web.cinema.model.Movie
import com.itransition.web.cinema.service.MovieService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class MovieController(private val service: MovieService) {

    @GetMapping("/movies")
    fun findAll() : List<Movie> = service.findAll()

    @GetMapping("/{id}")
    fun findOne(@PathVariable("id") id: Long) : Movie = service.findOne(id).orElseThrow()

    @PostMapping("/movie")
    fun save(@RequestBody movie: Movie) {
        service.save(movie)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) {
        service.deleteById(id)
    }
}