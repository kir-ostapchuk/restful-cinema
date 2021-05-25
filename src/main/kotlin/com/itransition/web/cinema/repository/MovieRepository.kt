package com.itransition.web.cinema.repository

import com.itransition.web.cinema.model.Movie
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : CrudRepository<Movie, Long> {
    // TODO(Add finding by name using custom query)
}