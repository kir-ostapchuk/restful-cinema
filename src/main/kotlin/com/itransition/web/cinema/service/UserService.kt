package com.itransition.web.cinema.service

import com.itransition.web.cinema.exception.ResourceNotFoundException
import com.itransition.web.cinema.model.User
import com.itransition.web.cinema.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository
) {

    fun findAll(): List<User> =
        repository.findAll().toList()

    fun findOne(id: Long): User =
        repository.findById(id)
            .orElseThrow { throw ResourceNotFoundException("Cannot find user by id: $id") }

    fun save(user: User): User =
        repository.save(user)

    fun deleteById(id: Long) =
        repository.deleteById(id)
}