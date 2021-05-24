package com.itransition.web.cinema.model

import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "users")
class User(

    @Column(name = "username")
    var username: String,

    @Column(name = "firstName")
    var firstName: String,

    @Column(name = "lastName")
    var lastName: String,

    @Column(name = "email")
    var email: String,

    @Column(name = "password")
    var password: String,

    @ManyToMany(fetch = FetchType.EAGER) // TODO: what's the difference between fetching types??
    @JoinTable(
        name = "user_roles",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")]
    )
    val roles: List<Role>,


    id: Long,
    created: Date,
    updated: Date,
    status: Status
) : BaseEntity(id, created, updated, status)