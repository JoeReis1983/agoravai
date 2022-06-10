package com.celsoBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celsoBackend.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    public List<Aluno> findByNomeContainsIgnoreCase(String nome);

    public Aluno findByNome(String nome);





}
