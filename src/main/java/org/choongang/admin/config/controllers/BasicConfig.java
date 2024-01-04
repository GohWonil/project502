package org.choongang.admin.config.controllers;

import lombok.Data;

@Data
public class BasicConfig {
  //null을 피하기 위해 기본값을 준다
  private String siteTitle = "";
  private String siteDescription = "";
  private String siteKeywords = "";
  private int cssJsVersion = 1;
  private String joinTerms = "";
}
