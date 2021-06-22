package com.itransition.web.cinema.repository

import com.itransition.web.cinema.model.Movie
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : CrudRepository<Movie, Long> {

    @Query("select * from movies WHERE name = :name")
    fun findByName(@Param("name") name: String): Movie
}