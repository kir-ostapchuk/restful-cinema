package com.itransition.web.cinema.configuration

import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

//@Bean // TODO
//fun corsConfigurer(): WebMvcConfigurer = object : WebMvcConfigurer {
//    override fun addCorsMappings(registry: CorsRegistry) {
//        registry.addMapping("/api/v1/movies")
//            .allowedOrigins("http://localhost:8080")
//    }
//}