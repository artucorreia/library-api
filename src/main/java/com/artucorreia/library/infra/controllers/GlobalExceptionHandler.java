package com.artucorreia.library.infra.controllers;

import com.artucorreia.library.domain.exceptions.ResourceAlreadyExistsException;
import com.artucorreia.library.domain.exceptions.ResourceNotFoundException;
import com.artucorreia.library.infra.controllers.dtos.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionResponse> handlerExceptions(
      Exception exception, WebRequest request) {
    return new ResponseEntity<>(
        ExceptionResponse.builder()
            .success(false)
            .message(exception.getMessage())
            .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .uri(request.getDescription(false))
            .timestamp(LocalDateTime.now())
            .build(),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ExceptionResponse> handlerResourceNotFoundExceptions(
      Exception exception, WebRequest request) {
    return new ResponseEntity<>(
        ExceptionResponse.builder()
            .success(false)
            .message(exception.getMessage())
            .code(HttpStatus.NOT_FOUND.value())
            .uri(request.getDescription(false))
            .timestamp(LocalDateTime.now())
            .build(),
        HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ResourceAlreadyExistsException.class)
  public ResponseEntity<ExceptionResponse> handlerResourceAlreadyExistsExceptions(
      Exception exception, WebRequest request) {
    return new ResponseEntity<>(
        ExceptionResponse.builder()
            .success(false)
            .message(exception.getMessage())
            .code(HttpStatus.BAD_REQUEST.value())
            .uri(request.getDescription(false))
            .timestamp(LocalDateTime.now())
            .build(),
        HttpStatus.BAD_REQUEST);
  }
}
