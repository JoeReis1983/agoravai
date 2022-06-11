package com.celsoBackend.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.celsoBackend.entity.Aluno;
import com.celsoBackend.entity.Autorizacao;
import com.celsoBackend.entity.Usuario;

public interface SegurancaService extends UserDetailsService{

    public Usuario criarUsuario(String nome, String senha, String autorizacao);

    public List<Usuario> buscarTodosUsuarios();

    public Usuario buscarUsuarioPorId(Long id);

    public Usuario buscarUsuarioPorNome(String nome);

    public Autorizacao buscarAutorizacaoPorNome(String nome);
    public UserDetails loadUserByUsername(String nome);

    
    public Aluno criarAluno(String nome, String p1, String p2, String trabalho);
    

    
    public List<Aluno> buscarTodosAlunos();
    
    
    
}