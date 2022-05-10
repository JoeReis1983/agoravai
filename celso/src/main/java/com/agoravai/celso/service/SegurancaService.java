package com.agoravai.celso.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.agoravai.celso.entity.Autorizacao;
import com.agoravai.celso.entity.Usuario;

public interface SegurancaService extends UserDetailsService {

    public Usuario criarUsuario(String nome, String senha, String autorizacao);

    public List<Usuario> buscarTodosUsuarios();

    public Usuario buscarUsuarioPorId(Long id);

    public Usuario buscarUsuarioPorNome(String nome);

    public Autorizacao buscarAutorizacaoPorNome(String nome);
    
}