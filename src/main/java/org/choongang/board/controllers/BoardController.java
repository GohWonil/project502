package org.choongang.board.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.board.repositories.BoardDataRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
  private final BoardDataRepository boardDataRepository;

//  @ResponseBody
//  @GetMapping("/test")
//  public void test(){
//    BoardData data = new BoardData();
//    data.setSubject("제목");
//    data.setContent("내용");
//    boardDataRepository.saveAndFlush(data);
  @GetMapping("/test2")
  @ResponseBody
  @PreAuthorize("hasAnyAuthority('ADMIN')")
  @Secured({"ROLE_ADMIN", "ROLE_MANAGER" })
  public void test2(){
    System.out.println("test2!!!");
  }
  //  }
}
