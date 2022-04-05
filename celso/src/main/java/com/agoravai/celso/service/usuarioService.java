package com.agoravai.celso.service;
import com.agoravai.celso.entity.Usuario;

public interface usuarioService {

  public Usuario novoUsuario(String nome, String senha, String role);
  
}
