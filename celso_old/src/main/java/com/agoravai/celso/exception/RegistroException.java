package com.agoravai.celso.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RegistroException extends RuntimeException {

  private static final long serialVersionUID = -3904954587935880412L;

  public RegistroException() {
    super();
  }

  public RegistroException(String message) {
    super(message);
  }

  public RegistroException(Throwable cause) {
    super(cause);
  }

  public RegistroException(String message, Throwable cause) {
    super(message, cause);
  }
  
}