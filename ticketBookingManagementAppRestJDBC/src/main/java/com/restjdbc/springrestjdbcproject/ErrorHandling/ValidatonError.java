package com.restjdbc.springrestjdbcproject.ErrorHandling;

import lombok.Data;

@Data
public class ValidatonError {
  private String code;
  private String message;

}
