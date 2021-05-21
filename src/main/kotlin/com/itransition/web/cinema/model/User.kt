package com.itransition.web.cinema.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "USERS")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @field:NotBlank(message = "Login is mandatory")
    var login: String? = "",

    @field:NotBlank(message = "Password is mandatory")
    var password: String? = "",

    var firstName: String? = "",

    var age: Int? = 0
)