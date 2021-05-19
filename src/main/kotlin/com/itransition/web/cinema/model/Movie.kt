package com.itransition.web.cinema.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("MOVIES")
data class Movie(@Id val id: Long, val name: String)