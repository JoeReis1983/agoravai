package com.agoravai.celso.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.security.auth.AuthPermission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import  com.agoravai.celso.security.JwtUtils;
import  com.agoravai.celso.security.Login;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin
public class LoginControl {

  @Autowired
  private AuthenticationManager authManager;

  @PostMapping()
  public Login autenticar(@RequestBody Login login) throws JsonProcessingException {
    System.out.println("autenticar");
    System.out.println(login.getUsername());
    System.out.println(login.getPassword());
    Authentication auth =new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
    System.out.println(auth);
    
    auth = authManager.authenticate(auth);
    System.out.println(auth);
    login.setPassword(null);
    login.setToken(JwtUtils.generateToken(auth));
    System.out.println(login);
    return login;
  }
  
}
