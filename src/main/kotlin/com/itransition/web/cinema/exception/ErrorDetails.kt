package com.itransition.web.cinema.exception

import java.util.Date

data class ErrorDetails(
    val timestamp: Date,
    val message: String,
    val details: String
)
