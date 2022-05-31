package com.agoravai.celso;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.agoravai.celso.entity.Perfil;
import com.agoravai.celso.entity.Usuario;
import com.agoravai.celso.repository.PerfilRepository;
import com.agoravai.celso.repository.UsuarioRepository;
import com.agoravai.celso.service.SegurancaService;

@SpringBootTest
@Transactional
@Rollback
class CelsoApplicationTests {
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private PerfilRepository autRepo;

    @Autowired
    private SegurancaService segService;

	@Test
	void contextLoads() {
    }
    
    @Test
    void testaInsercao() {
        Usuario usuario = new Usuario();
        usuario.setNome("Usuario");
        usuario.setSenha("SenhaF0rte");
        usuario.setPerfis(new HashSet<Perfil>());
        Perfil aut = new Perfil();
        aut.setNome("ROLE_USUARIO");
        autRepo.save(aut);
        usuario.getPerfis().add(aut);
        usuarioRepo.save(usuario);
        assertNotNull(usuario.getPerfis().iterator().next().getId());
    }

    @Test
    void testaInsercaoPerfil() {
        Usuario usuario = new Usuario();
        usuario.setNome("Usuario2");
        usuario.setSenha("SenhaF0rte");
        usuarioRepo.save(usuario);
        Perfil aut = new Perfil();
        aut.setNome("ROLE_USUARIO2");
        aut.setUsuarios(new HashSet<Usuario>());
        aut.getUsuarios().add(usuario);
        autRepo.save(aut);
        assertNotNull(aut.getUsuarios().iterator().next().getId());
    }

    @Test
    void testaPerfil() {
        Usuario usuario = usuarioRepo.findById(1L).get();
        assertEquals("ROLE_ADMIN", usuario.getPerfis().iterator().next().getNome());
    }

    @Test
    void testaUsuario() {
        Perfil aut = autRepo.findById(1L).get();
        assertEquals("Usuario", aut.getUsuarios().iterator().next().getNome());
    }

    @Test
    void testaBuscaUsuarioNomeContains() {
        List<Usuario> usuarios = usuarioRepo.findByNomeContainsIgnoreCase("m");
        assertFalse(usuarios.isEmpty());
    }

    @Test
    void testaBuscaUsuarioNome() {
        Usuario usuario = usuarioRepo.findByNome("admin");
        assertNotNull(usuario);
    }

    @Test
    void testaBuscaUsuarioNomeQuery() {
        Usuario usuario = usuarioRepo.buscaUsuarioPorNome("admin");
        assertNotNull(usuario);
    }

    @Test
    void testaBuscaUsuarioNomeSenha() {
        Usuario usuario = usuarioRepo.findByNomeAndSenha("Usuario", "SenhaF0rte");
        assertNotNull(usuario);
    }

    @Test
    void testaBuscaUsuarioNomeSenhaQuery() {
        Usuario usuario = usuarioRepo.buscaUsuarioPorNomeESenha("Usuario", "SenhaF0rte");
        assertNotNull(usuario);
    }

    @Test
    void testaBuscaUsuarioNomePerfil() {
        List<Usuario> usuarios = usuarioRepo.findByPerfisNome("ROLE_ADMIN");
        assertFalse(usuarios.isEmpty());
    }

    @Testcd
    void testaBuscaUsuarioNomePerfilQuery() {
        List<Usuario> usuarios = usuarioRepo.buscaPorNomePerfil("ROLE_ADMIN");
        assertFalse(usuarios.isEmpty());
    }

    @Test
    void testaServicoCriaUsuario() {
        Usuario usuario = segService.criarUsuario("normal", "senha123", "ROLE_USUARIO");
        assertNotNull(usuario);
    }

}
