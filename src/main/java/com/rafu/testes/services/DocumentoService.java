package com.rafu.testes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafu.testes.entities.Documento;
import com.rafu.testes.repositories.DocumentoRepository;
import com.rafu.testes.services.exceptions.DataException;
import com.rafu.testes.services.exceptions.ObjectNotFoundException;

@Service
public class DocumentoService {
	@Autowired
	private DocumentoRepository repository;

	public List<Documento> findAll() {
		return repository.findAll();
	}

	public Documento findById(Long id) {
		Optional<Documento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:"+id+", Tipo: "+Documento.class.getName()));
	}
	
	public Documento create(Documento obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Documento update(Long id, Documento documento) {
		Documento obj = findById(id);
		if(documento.getDoc()!=null) {
			obj.setDoc(documento.getDoc());
		}
		if(documento.getTypeDoc()!=null) {
			obj.setTypeDoc(documento.getTypeDoc());	
		}
		return repository.save(obj);
	}
	public void delete(Long id) {
		Documento documento = findById(id);
		try {
			repository.deleteById(documento.getId());
		} catch (Exception e) {
			throw new DataException("Documento possui documentos associados");
		}
	}

}
