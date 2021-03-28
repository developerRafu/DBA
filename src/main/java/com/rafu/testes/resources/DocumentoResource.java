package com.rafu.testes.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafu.testes.entities.Documento;
import com.rafu.testes.entities.User;
import com.rafu.testes.services.DocumentoService;

@RestController
@RequestMapping(value = "/docs")
public class DocumentoResource {
	@Autowired
	private DocumentoService service;

	@GetMapping
	public ResponseEntity<List<Documento>> findAll() {
		List<Documento> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Documento> findById(@PathVariable Long id) {
		Documento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
