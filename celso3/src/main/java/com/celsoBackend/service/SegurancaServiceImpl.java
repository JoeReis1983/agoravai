package com.celsoBackend.service;

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

import com.celsoBackend.entity.Trabalho;
import com.celsoBackend.entity.Autorizacao;
import com.celsoBackend.entity.Usuario;
import com.celsoBackend.entity.Aluno;
import com.celsoBackend.exception.RegistroNaoEncontradoException;
import com.celsoBackend.repository.AutorizacaoRepository;
import com.celsoBackend.repository.UsuarioRepository;
import com.celsoBackend.repository.TrabalhoRepository;
import com.celsoBackend.repository.AlunoRepository;

@Service("segurancaService")
public class SegurancaServiceImpl implements SegurancaService {

    @Autowired
    private AutorizacaoRepository autRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private TrabalhoRepository trabalhoRepo;

    @Autowired
    private AlunoRepository alunoRepo;


    @Autowired
    private PasswordEncoder passEncoder;

    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public Usuario criarUsuario(String nome, String senha, String autorizacao) {
        Autorizacao aut = autRepo.findByNome(autorizacao);
        if(aut == null) {
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autRepo.save(aut);
        }
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(passEncoder.encode(senha));
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);
        return usuario;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public Aluno criarAluno(String nome, String p1, String p2, String trabalho) {        
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setP1(p1);
        aluno.setP2(p2);
        aluno.setTrabalho(trabalho);
        alunoRepo.save(aluno);
        return aluno;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
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
      throw new RegistroNaoEncontradoException("Usu??rio n??o encontrado!");
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Usuario buscarUsuarioPorNome(String nome) {
      Usuario usuario = usuarioRepo.findByNome(nome);
      if(usuario != null) {
        return usuario;
      }
      throw new RegistroNaoEncontradoException("Usu??rio n??o encontrado!");

    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Autorizacao buscarAutorizacaoPorNome(String nome) {
      Autorizacao autorizacao = autRepo.findByNome(nome);
      if(autorizacao != null) {
        return autorizacao;
      }
      throw new RegistroNaoEncontradoException("Autoriza????o n??o encontrada!");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Usuario usuario = usuarioRepo.findByNome(username);
        if(usuario == null){
          throw new UsernameNotFoundException("Usuario"+ username + "n??o encontrado!");
        }
      return User.builder().username(username).password(usuario.getSenha())
      .authorities(usuario.getAutorizacoes().stream()
          .map(Autorizacao::getNome).collect(Collectors.toList())
          .toArray(new String[usuario.getAutorizacoes().size()]))
      .build();
    }

    @Override
    public Trabalho criarTrabalho(String titulo, String texto) {
        Trabalho trabalho = new Trabalho();
        trabalho.setTitulo(titulo);
        trabalho.setTexto(texto);
        trabalhoRepo.save(trabalho);
        return trabalho;
    }

    @Override
    public List<Trabalho> buscarTodosTrabalhos() {
      return trabalhoRepo.findAll();
    }

    @Override
    public List<Aluno> buscarTodosAlunos() {
      return alunoRepo.findAll();
    }
    
}