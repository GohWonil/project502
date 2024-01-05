package org.choongang.commons.rest;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class JSONData<T> {
  private HttpStatus status = HttpStatus.OK;
  private boolean success;

  @NonNull
  private T data;
  private String message;
}
