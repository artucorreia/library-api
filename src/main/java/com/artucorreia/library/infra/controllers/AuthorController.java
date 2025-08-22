package com.artucorreia.library.infra.controllers;

import com.artucorreia.library.application.usecases.CreateAuthorUseCase;
import com.artucorreia.library.domain.entities.Author;
import com.artucorreia.library.infra.controllers.constants.AuthorConstant;
import com.artucorreia.library.infra.controllers.dtos.CreateAuthorDTO;
import com.artucorreia.library.infra.controllers.dtos.ResponseDTO;
import com.artucorreia.library.infra.controllers.mapper.AuthorControllerMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/authors")
public class AuthorController {
  private final CreateAuthorUseCase createAuthorUseCase;
  private final AuthorControllerMapper authorControllerMapper;

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO<String>> create(@Valid @RequestBody CreateAuthorDTO createAuthorDTO) {
    Author author = authorControllerMapper.createDTOToDomain(createAuthorDTO);
    createAuthorUseCase.execute(author);
    ResponseDTO<String> response =
        new ResponseDTO<>(
            true, AuthorConstant.MESSAGE_201, AuthorConstant.STATUS_201, LocalDateTime.now(), null);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
