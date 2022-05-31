package com.agoravai.celso.service;

import com.agoravai.celso.entity.Usuario;

public interface SegurancaService {

    public Usuario criarUsuario(String nome, String senha, String perfil);
    
}