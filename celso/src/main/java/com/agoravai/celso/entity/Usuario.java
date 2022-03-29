package com.agoravai.celso.entity;

import javax.persistenc.Entity;
import javax.persistenc.Table;


@Entity
@Table(name = "usr_usuario")
public class Usuario {
  @JsonView(View.UsuarioCompleto.class)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "usr_id")
  private Long id;

  @JsonView({View.UsuarioResumo.class, View.AutorizacaoResumo.class})
  @Column(name = "usr_nome")
  private String nome;

  @Column(name = "usr_senha")
  private String senha;

  @JsonView(View.UsuarioResumo.class)
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "uau_usuario_autorizacao",
      joinColumns = { @JoinColumn(name = "usr_id")},
      inverseJoinColumns = { @JoinColumn(name = "aut_id") }
      )
  private Set<Autorizacao> autorizacoes;

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

  public Set<Autorizacao> getAutorizacoes() {
      return this.autorizacoes;
  }

  public void setAutorizacoes(Set<Autorizacao> autorizacoes) {
      this.autorizacoes = autorizacoes;
  }

  
}
