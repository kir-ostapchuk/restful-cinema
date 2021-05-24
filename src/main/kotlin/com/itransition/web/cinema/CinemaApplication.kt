package com.itransition.web.cinema

import com.itransition.web.cinema.model.BaseEntity
import com.itransition.web.cinema.model.Role
import com.itransition.web.cinema.model.Status
import java.util.Date
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CinemaApplication

fun main(args: Array<String>) {
    runApplication<CinemaApplication>(*args)
}


