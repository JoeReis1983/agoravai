package com.agoravai.celso.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agoravai.celso.entity.Perfil;
import com.agoravai.celso.entity.Usuario;
import com.agoravai.celso.exception.RegistroException;
import com.agoravai.celso.repository.PerfilRepository;
import com.agoravai.celso.repository.UsuarioRepository;

@Service("segurancaService")
public class SegurancaServiceImpl implements SegurancaService {

    @Autowired
    private PerfilRepository autRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private PasswordEncoder passEncoder;

    // @PreAuthorize("hasRole('ADMIN')")
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
        usuario.setSenha(passEncoder.encode(senha));
        usuario.setPerfil(new HashSet<Perfil>());
        usuario.getPerfil().add(aut);
        usuarioRepo.save(usuario);
        return usuario;
    }

    @Override
    // @PreAuthorize("hasRole('ADMIN')")
    public List<Usuario> buscarTodosUsuarios() {
      return usuarioRepo.findAll();
    }

    @Override
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public Usuario buscarUsuarioPorId(Long id) {
      Optional<Usuario> usuarioOp = usuarioRepo.findById(id);
      if(usuarioOp.isPresent()) {
        return usuarioOp.get();
      }
      throw new RegistroException("Usuário não encontrado!");
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Usuario buscarUsuarioPorNome(String nome) {
      Usuario usuario = usuarioRepo.findByNome(nome);
      if(usuario != null) {
        return usuario;
      }
      throw new RegistroException("Usuário não encontrado!");

    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Perfil buscarPerfilPorNome(String nome) {
      Perfil perfil = autRepo.findByNome(nome);
      if(perfil != null) {
        return perfil;
      }
      throw new RegistroException("Autorização não encontrada!");
    }

    // @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Usuario usuario = usuarioRepo.findByNome(username);
        if(usuario == null){
          throw new UsernameNotFoundException("Usuario"+ username + "não encontrado!");
        }
      return User.builder().username(username).password(usuario.getSenha())
      .authorities(usuario.getPerfil().stream()
          .map(Perfil::getNome).collect(Collectors.toList())
          .toArray(new String[usuario.getPerfil().size()]))
      .build();
    }

    
}