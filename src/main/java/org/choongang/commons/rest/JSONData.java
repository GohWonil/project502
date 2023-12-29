package org.choongang.commons.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JSONData<T> {
  private HttpStatus status = HttpStatus.OK;
  private boolean success;
  private T data;
  private String message;
}
