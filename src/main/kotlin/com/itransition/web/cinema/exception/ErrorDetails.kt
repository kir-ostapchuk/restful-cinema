package com.itransition.web.cinema.exception

import java.util.Date

data class ErrorDetails(
    private val timestamp: Date,
    private val message: String,
    private val details: String
)
