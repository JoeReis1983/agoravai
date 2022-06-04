package com.agoravai.celso.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.agoravai.celso.controller.View;

@Entity
@Table(name = "tbl_perfil")
public class Perfil {
    @JsonView(View.UsuarioCompleto.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perfilId")
    private Long id;
    
    @JsonView({View.UsuarioResumo.class, View.PerfilResumo.class})
    @Column(name = "perfilNome")
    private String nome;

    @JsonView(View.PerfilResumo.class)
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "perfis")
    private Set<Usuario> usuarios;

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

    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}