package com.artucorreia.library.infra.controllers;

import com.artucorreia.library.application.usecases.CreateCategoryUseCase;
import com.artucorreia.library.application.usecases.DeleteCategoryByIdUseCase;
import com.artucorreia.library.application.usecases.FindCategoryByIdUseCase;
import com.artucorreia.library.application.usecases.UpdateCategoryUseCase;
import com.artucorreia.library.domain.entities.Category;
import com.artucorreia.library.infra.controllers.constants.CategoryConstant;
import com.artucorreia.library.infra.controllers.dtos.CategoryResponseDTO;
import com.artucorreia.library.infra.controllers.dtos.CreateCategoryDTO;
import com.artucorreia.library.infra.controllers.dtos.ResponseDTO;
import com.artucorreia.library.infra.controllers.dtos.UpdateCategoryDTO;
import com.artucorreia.library.infra.controllers.mapper.CategoryControllerMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

  private final FindCategoryByIdUseCase findCategoryByIdUseCase;
  private final CreateCategoryUseCase createCategoryUseCase;
  private final UpdateCategoryUseCase updateCategoryUseCase;
  private final DeleteCategoryByIdUseCase deleteCategoryByIdUseCase;
  private final CategoryControllerMapper categoryControllerMapper;

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO<CategoryResponseDTO>> findById(@PathVariable Long id) {
    Category category = findCategoryByIdUseCase.execute(id);
    CategoryResponseDTO categoryResponseDTO =
        categoryControllerMapper.domainToResponseDTO(category);
    ResponseDTO<CategoryResponseDTO> response =
        new ResponseDTO<>(
            true,
            CategoryConstant.MESSAGE_200,
            CategoryConstant.STATUS_200,
            LocalDateTime.now(),
            categoryResponseDTO);
    return ResponseEntity.ok(response);
  }

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO<String>> create(
      @Valid @RequestBody CreateCategoryDTO createCategoryDTO) {
    Category category = categoryControllerMapper.createDTOToDomain(createCategoryDTO);
    createCategoryUseCase.execute(category);
    ResponseDTO<String> response =
        new ResponseDTO<>(
            true,
            CategoryConstant.MESSAGE_201,
            CategoryConstant.STATUS_201,
            LocalDateTime.now(),
            null);
    return ResponseEntity.ok(response);
  }

  @PutMapping(
      value = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO<String>> update(
      @PathVariable Long id, @Valid @RequestBody UpdateCategoryDTO updateCategoryDTO) {
    Category newValues = categoryControllerMapper.updateDTOToDomain(updateCategoryDTO);
    updateCategoryUseCase.execute(id, newValues);
    ResponseDTO<String> response =
        new ResponseDTO<>(
            true,
            CategoryConstant.MESSAGE_200,
            CategoryConstant.STATUS_200,
            LocalDateTime.now(),
            null);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO<String>> deleteById(@PathVariable Long id) {
    deleteCategoryByIdUseCase.execute(id);
    ResponseDTO<String> response =
        new ResponseDTO<>(
            true,
            CategoryConstant.MESSAGE_204,
            CategoryConstant.STATUS_204,
            LocalDateTime.now(),
            null);
    return ResponseEntity.ok(response);
  }
}
