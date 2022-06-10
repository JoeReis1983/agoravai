package com.celsoBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celsoBackend.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

    public List<Trabalho> findByTituloContainsIgnoreCase(String titulo);

    public Trabalho findByTitulo(String titulo);





}
