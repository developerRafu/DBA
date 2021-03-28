package com.rafu.testes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafu.testes.entities.Documento;
import com.rafu.testes.entities.User;
import com.rafu.testes.repositories.DocumentoRepository;

@Service
public class DocumentoService {
	@Autowired
	private DocumentoRepository repository;

	public List<Documento> findAll() {
		return repository.findAll();
	}

	public Documento findById(Long id) {
		Optional<Documento> obj = repository.findById(id);
		return obj.orElseGet(null);
	}

}
