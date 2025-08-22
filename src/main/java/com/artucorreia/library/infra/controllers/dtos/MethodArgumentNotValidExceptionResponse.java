package com.artucorreia.library.infra.controllers.dtos;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MethodArgumentNotValidExceptionResponse {
  private Boolean success;
  private String message;
  private Map<String, String> parameters;
  private Integer code;
  private String uri;
  private LocalDateTime timestamp;
}
