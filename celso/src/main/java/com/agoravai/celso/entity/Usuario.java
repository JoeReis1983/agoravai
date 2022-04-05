package com.agoravai.celso.entity;

import javax.annotation.processing.Generated;
import javax.persistenc.Entity;
import javax.persistenc.Table;


@Entity
@Table(name = "usr_usuario")
public class Usuario {  
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="usr_id")
    private Long id;

    @Column(name="usr_nome")
    private String nome;

    @Column(name="usr_senha")
    private String senha;

    @Column(name="usr_role")
    private String role;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
