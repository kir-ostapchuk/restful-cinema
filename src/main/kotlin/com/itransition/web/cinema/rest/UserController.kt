package com.itransition.web.cinema.rest

import com.itransition.web.cinema.model.User
import com.itransition.web.cinema.service.UserService
import javax.validation.Valid
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin(origins = ["http://localhost:3030"])
class UserController(
    private val service: UserService
) {

    @GetMapping
    fun findAll(): List<User> = service.findAll()

    @GetMapping("/{id}")
    fun findOne(@PathVariable("id") id: Long): User =
        service.findOne(id)

    @PostMapping
    fun save(@Valid @RequestBody user: User) =
        service.save(user)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) {
        service.deleteById(id)
    }
}