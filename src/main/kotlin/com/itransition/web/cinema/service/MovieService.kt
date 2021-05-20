package com.itransition.web.cinema.service

import com.itransition.web.cinema.model.Movie
import com.itransition.web.cinema.repository.MovieRepository
import java.util.Optional
import org.springframework.stereotype.Service

@Service
class MovieService(
    private val repository: MovieRepository
) {

    fun findAll(): List<Movie> =
        repository.findAll().toList()

    fun findOne(id: Long): Optional<Movie> =
        repository.findById(id)

    fun save(movie: Movie): Movie =
        repository.save(movie)

    fun deleteById(id: Long) =
        repository.deleteById(id)
}