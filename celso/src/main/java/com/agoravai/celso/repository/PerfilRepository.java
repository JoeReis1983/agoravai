package com.agoravai.celso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agoravai.celso.entity.Autorizacao;

public interface PerfilRepository extends JpaRepository<Autorizacao, Long> {

    public Autorizacao findByNome(String autorizacao);
    
}