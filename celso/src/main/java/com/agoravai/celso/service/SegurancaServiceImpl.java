package com.agoravai.celso.service;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agoravai.celso.entity.Perfil;
import com.agoravai.celso.entity.Usuario;
import com.agoravai.celso.repository.PerfilRepository;
import com.agoravai.celso.repository.UsuarioRepository;

@Service("segurancaService")
public class SegurancaServiceImpl implements SegurancaService {

    @Autowired
    private PerfilRepository autRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Transactional
    public Usuario criarUsuario(String nome, String senha, String perfil) {
        Perfil aut = autRepo.findByNome(perfil);
        if(aut == null) {
            aut = new Perfil();
            aut.setNome(perfil);
            autRepo.save(aut);
        }
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setPerfis(new HashSet<Perfil>());
        usuario.getPerfis().add(aut);
        usuarioRepo.save(usuario);
        return usuario;
    }
    
}