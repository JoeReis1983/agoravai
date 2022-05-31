package com.agoravai.celso.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agoravai.celso.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public List<Usuario> findByNomeContainsIgnoreCase(String nome);

    public Usuario findByNome(String nome);

    @Query("select u from Usuario u where u.nome = ?1")
    public Usuario buscaUsuarioPorNome(String nome);

    public Usuario findByNomeAndSenha(String nome, String senha);

    @Query("select u from Usuario u where u.nome = ?1 and u.senha = ?2")
    public Usuario buscaUsuarioPorNomeESenha(String nome, String senha);

    public List<Usuario> findByPerfisNome(String perfil);

    @Query("select u from Usuario u inner join u.perfis a where a.nome = ?1")
    public List<Usuario> buscaPorNomePerfil(String perfil);
    
}
