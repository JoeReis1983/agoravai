package com.agoravai.celso.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeControl {

  @GetMapping
  public String welcome() {
    return "It's Works!!!";
  }
  
}