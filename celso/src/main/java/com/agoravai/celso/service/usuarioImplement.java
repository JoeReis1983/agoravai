package com.agoravai.celso.service;

import com.agoravai.celso.entity.Usuario;
import com.agoravai.celso.repository.usuarioRepository;

@Service("usuarioService")
public class usuarioImplement implements usuarioService{

  @Autowired
  private UsuarioRepository usuarioRepo;

  @Override
  @Transactional

  public Usuario novoUsuario( String nome, String senha, String role){

    Usuario usuario = new Usuario();
    usuario.setNome(nome);
    usuario.setSenha(senha);
    usuario.setRole(role);

    usuarioRepo.save(usuario);
    return usuario;
    
  }

  
}
