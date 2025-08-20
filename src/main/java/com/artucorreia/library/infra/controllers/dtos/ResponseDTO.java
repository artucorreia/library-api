package com.artucorreia.library.infra.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO<T> {
  private Boolean success;
  private String message;
  private String code;
  private LocalDateTime timestamp;
  private T data;
}
