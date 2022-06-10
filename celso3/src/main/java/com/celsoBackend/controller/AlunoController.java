package com.celsoBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import com.celsoBackend.entity.Aluno;
import com.celsoBackend.service.SegurancaService;

@RestController
@RequestMapping(value ="/aluno")
@CrossOrigin
public class AlunoController {
    
 @Autowired
  private SegurancaService segurancaService;

  @JsonView(View.AlunoCompleto.class)
  @GetMapping()
  public List<Aluno> buscarTodas() {
    return segurancaService.buscarTodosAlunos();
  }

  
  @PostMapping
  public ResponseEntity<Aluno> cadastraNovoUsuario(@RequestBody Aluno aluno,
        UriComponentsBuilder uriComponentsBuilder) {
    aluno = segurancaService.criarAluno(aluno.getNome(), aluno.getP1(),aluno.getP2(),aluno.getTrabalho());
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.setLocation(
        uriComponentsBuilder.path(
            "/aluno/" + aluno.getId()).build().toUri());
    return new ResponseEntity<Aluno>(aluno, responseHeaders, HttpStatus.CREATED);
  }
}
