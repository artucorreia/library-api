package com.artucorreia.library.infra.controllers;

import com.artucorreia.library.application.usecases.CreateAuthorUseCase;
import com.artucorreia.library.application.usecases.FindAuthorByIdUseCase;
import com.artucorreia.library.domain.entities.Author;
import com.artucorreia.library.infra.controllers.constants.AuthorConstant;
import com.artucorreia.library.infra.controllers.dtos.AuthorResponseDTO;
import com.artucorreia.library.infra.controllers.dtos.CreateAuthorDTO;
import com.artucorreia.library.infra.controllers.dtos.ResponseDTO;
import com.artucorreia.library.infra.controllers.mapper.AuthorControllerMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
  private final FindAuthorByIdUseCase findAuthorByIdUseCase;
  private final CreateAuthorUseCase createAuthorUseCase;
  private final AuthorControllerMapper authorControllerMapper;

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO<AuthorResponseDTO>> findById(@PathVariable Long id) {
    AuthorResponseDTO authorResponseDTO =
        authorControllerMapper.domainToResponseDTO(findAuthorByIdUseCase.execute(id));
    ResponseDTO<AuthorResponseDTO> response =
        new ResponseDTO<>(
            true,
            AuthorConstant.MESSAGE_200,
            AuthorConstant.STATUS_200,
            LocalDateTime.now(),
            authorResponseDTO);
    return ResponseEntity.ok(response);
  }

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO<String>> create(
      @Valid @RequestBody CreateAuthorDTO createAuthorDTO) {
    Author author = authorControllerMapper.createDTOToDomain(createAuthorDTO);
    createAuthorUseCase.execute(author);
    ResponseDTO<String> response =
        new ResponseDTO<>(
            true, AuthorConstant.MESSAGE_201, AuthorConstant.STATUS_201, LocalDateTime.now(), null);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
