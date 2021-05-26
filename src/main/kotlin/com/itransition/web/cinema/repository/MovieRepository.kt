package com.itransition.web.cinema.repository

import com.itransition.web.cinema.model.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : JpaRepository<Movie, Long> {
    // TODO(Add finding by name using custom query)

    @Query("SELECT m FROM Movie m WHERE m.name = :name")
    fun findByName(@Param("name") name: String): Movie
}