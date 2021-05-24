package com.itransition.web.cinema.model

import java.util.Date
import javax.persistence.Column
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate

@MappedSuperclass
class BaseEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @CreatedDate
    @Column(name = "created")
    var created: Date,

    @LastModifiedDate
    @Column(name = "updated")
    var updated: Date,

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    var status: Status
)