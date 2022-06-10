package com.celsoBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celsoBackend.entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {

    public Autorizacao findByNome(String autorizacao);
    
}