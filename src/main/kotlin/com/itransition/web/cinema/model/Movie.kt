package com.itransition.web.cinema.model

import javax.validation.constraints.NotBlank
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("movies")
class Movie(

    @Id
    var id: Long? = null,

    @field:NotBlank(message = "Name is mandatory")
    @Column("name")
    var name: String? = ""
)