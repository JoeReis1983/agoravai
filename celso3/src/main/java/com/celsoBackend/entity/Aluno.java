package com.celsoBackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import com.celsoBackend.controller.View;

@Entity
@Table(name = "alu_aluno")
public class Aluno {


    @JsonView(View.AlunoCompleto.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alu_id")
    private Long id;
    
    @JsonView({View.AlunoCompleto.class})
    @Column(name = "alu_nome")
    private String nome;

    @JsonView({View.AlunoCompleto.class})
    @Column(name = "alu_p1")
    private String p1;

    @JsonView({View.AlunoCompleto.class})
    @Column(name = "alu_p2")
    private String p2;

    @JsonView({View.AlunoCompleto.class})
    @Column(name = "alu_trabalho")
    private String trabalho;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(String trabalho) {
        this.trabalho = trabalho;
    }

    



}
