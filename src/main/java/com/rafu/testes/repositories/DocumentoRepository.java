package com.rafu.testes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafu.testes.entities.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

}
