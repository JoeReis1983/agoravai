package com.agoravai.celso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.agoravai.celso.entity.Perfil;
import com.agoravai.celso.entity.Usuario;
import com.agoravai.celso.repository.PerfilRepository;
import com.agoravai.celso.repository.UsuarioRepository;
import com.agoravai.celso.service.SegurancaService;

@SpringBootTest
@Transactional

class CelsoApplicationTests {

    
      @Autowired
      private UsuarioRepository usuarioRepo;
    
      @Autowired
      private PerfilRepository autRepo;
    
      @Autowired
      private SegurancaService segService;
    
      @BeforeAll
      
      // static void init(@Autowired JdbcTemplate jdbcTemplate) {
        // jdbcTemplate.update(
        //     "insert into tbl_usuario (user_nome, user_senha) values(?,?)",
        //         "Minedaso", "Senh@F0rte");
        // // jdbcTemplate.update(
        //     "insert into tbl_perfil (perfil_nome) values(?)",
        //         "ROLE_ADMINsSssasss");
        // jdbcTemplate.update(
        //     "insert into uau_usuario_perfil (user_id, perfil_id) values(?,?)",
        //         1L, 2);
      // }

      
    
    @Test
    
    void testaInsercao() {
        Usuario usuario = new Usuario();
        usuario.setNome("Usuario");
        usuario.setSenha("Senh@F0rte");
        usuario.setPerfil(new HashSet<Perfil>());
        Perfil aut = new Perfil();
        aut.setNome("ROLE_USUARIO");
        autRepo.save(aut);
        usuario.getPerfil().add(aut);
        usuarioRepo.save(usuario);
        assertNotNull(usuario.getPerfil().iterator().next().getId());
    }

    @Test
    void testaInsercaoPerfil() {
        Usuario usuario = new Usuario();
        usuario.setNome("Usuario2");
        usuario.setSenha("Senh@F0rte");
        usuarioRepo.save(usuario);
        Perfil aut = new Perfil();
        aut.setNome("ROLE_USUARIO2");
        aut.setUsuarios(new HashSet<Usuario>());
        aut.getUsuarios().add(usuario);
        autRepo.save(aut);
        assertNotNull(aut.getUsuarios().iterator().next().getId());
    }

    // @Test
    // void testaPerfil() {
    //     Usuario usuario = usuarioRepo.findById(1L).get();
    //     assertEquals("ROLE_ADMIN", usuario.getPerfil().iterator().next().getNome());
    // }

    // @Test
    // void testaBuscaUsuarioNomeContains() {
    //     List<Usuario> usuarios = usuarioRepo.findByNomeContainsIgnoreCase("m");
    //     assertFalse(usuarios.isEmpty());
    // }

    // @Test
    // void testaBuscaUsuarioPorNome() {
    //     Usuario usuario = usuarioRepo.findByNome("admin");
    //     assertNotNull(usuario);
    // }

    // @Test
    // void testaBuscaUsuarioNomeQuery() {
    //     Usuario usuario = usuarioRepo.buscaUsuarioPorNome("admin");
    //     assertNotNull(usuario);
    // }

    // @Test
    // void testaBuscaUsuarioNomeSenha() {
    //     Usuario usuario = usuarioRepo.findByNomeAndSenha("celso", "admin123");
    //     assertNotNull(usuario);
    // }

    // @Test
    // void testaBuscaUsuarioNomeSenhaQuery() {
    //     Usuario usuario = usuarioRepo.buscaUsuarioPorNomeESenha("celso", "admin123");
    //     assertNotNull(usuario);
    // }

    // @Test
    // void testaBuscaUsuarioNomePerfil() {
    //     List<Usuario> usuarios = usuarioRepo.findByPerfilNome("ROLE_ADMIN");
    //     assertFalse(usuarios.isEmpty());
    // }

    // @Test
    // void testaBuscaUsuarioNomePerfilQuery() {
    //     List<Usuario> usuarios = usuarioRepo.buscaPorNomePerfil("ROLE_ADMIN");
    //     assertFalse(usuarios.isEmpty());
    // }

    // @Test
    // void testaServicoCriaUsuario() {
    //     Usuario usuario = segService.criarUsuario("normal", "senha123", "ROLE_USUARIO");
    //     assertNotNull(usuario);
    // }

}
