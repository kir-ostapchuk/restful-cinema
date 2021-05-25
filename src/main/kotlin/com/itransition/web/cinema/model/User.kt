
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
    private val id: Long? = null,

    @field:NotBlank(message = "Login is mandatory")
    private val login: String? = "",

    @field:NotBlank(message = "Password is mandatory")
    private val password: String? = "",

    private val firstName: String? = "",

    private val age: Int? = 0
)