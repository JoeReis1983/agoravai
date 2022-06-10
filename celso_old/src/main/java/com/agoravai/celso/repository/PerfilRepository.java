package com.agoravai.celso.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.agoravai.celso.entity.Perfil;
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    public Perfil findByNome(String perfil);
    
}