package com.itransition.web.cinema.model

import javax.validation.constraints.NotBlank
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("users")
class User(

    @Id
    var id: Long? = null,

    @Column("login")
    @field:NotBlank(message = "Login is mandatory")
    var login: String? = "",

    @Column("password")
    @field:NotBlank(message = "Password is mandatory")
    var password: String? = "",

    @Column("first_name")
    var firstName: String? = "",

    @Column("age")
    var age: Int? = 0
)