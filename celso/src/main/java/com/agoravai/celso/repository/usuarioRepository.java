package com.agoravai.celso.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.agoravai.celso.entity.Usuario;

public interface usuarioRepository extends JpaRepository<Usuario, Long>{
  
}
