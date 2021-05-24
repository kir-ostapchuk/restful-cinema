package com.itransition.web.cinema.model

import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "roles")
class Role(

    @Column(name = "name")
    var name: String,

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    val users: List<User>,

    id: Long,
    created: Date,
    updated: Date,
    status: Status
    ) : BaseEntity(id, created, updated, status)
