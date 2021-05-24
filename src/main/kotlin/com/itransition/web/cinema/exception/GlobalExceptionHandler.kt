package com.itransition.web.cinema.exception

import java.util.Date
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(
        exception: ResourceNotFoundException,
        request: WebRequest
    ): ResponseEntity<Any> {
        val errorDetails = ErrorDetails(Date(), exception.message.toString(), request.getDescription(false))
        return ResponseEntity(errorDetails, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(BindException::class)
    fun handleMethodArgumentNotValidException(
        exception: BindException,
        request: WebRequest
    ): ResponseEntity<Any> {
        val errorDetails = ErrorDetails(Date(), exception.message, request.getDescription(false))
        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    fun handleGlobalException(
        exception: Exception,
        request: WebRequest
    ): ResponseEntity<Any> {
        val errorDetails = ErrorDetails(Date(), exception.message.toString(), request.getDescription(false))
        return ResponseEntity(errorDetails, HttpStatus.NOT_FOUND)
    }
}