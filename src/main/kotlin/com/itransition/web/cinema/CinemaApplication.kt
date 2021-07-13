package com.itransition.web.cinema

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(
    info = Info(
        title = "Restful cinema API", version = "1.0.0", description = "Restful cinema API",
        contact = Contact(email = "xfaseex1@gmail.com")
    ),
//    servers = [Server(url = "http://localhost:8080/api/v1", description = "Dev server")]
)
class CinemaApplication

fun main(args: Array<String>) {
    runApplication<CinemaApplication>(*args)
}


