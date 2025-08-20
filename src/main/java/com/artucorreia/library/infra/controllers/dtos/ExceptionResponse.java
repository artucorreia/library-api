package com.artucorreia.library.infra.controllers.dtos;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExceptionResponse {
  private Boolean success;
  private String message;
  private Integer code;
  private String uri;
  private LocalDateTime timestamp;
}
