package com.restjdbc.springrestjdbcproject.ErrorHandling;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetails {
  private String title;
  private int status;
  private String detail;
  private long timeStamp;
  private String path;
  private String developerMessage;
  private Map<String,List<ValidatonError>> errors=new HashMap<>();

}
