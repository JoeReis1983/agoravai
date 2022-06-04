package com.agoravai.celso.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.agoravai.celso.entity.Usuario;
import com.agoravai.celso.entity.Perfil;

public interface SegurancaService {

    public Usuario criarUsuario(String nome, String senha, String perfil);
    public List<Usuario> buscarTodosUsuarios();

    public Usuario buscarUsuarioPorId(Long id);

    public Usuario buscarUsuarioPorNome(String nome);

    public Perfil buscarPerfilPorNome(String nome);
    
}