package com.rafu.testes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafu.testes.entities.User;
import com.rafu.testes.repositories.UserRepository;
import com.rafu.testes.services.exceptions.ObjectNotFoundException;


@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	public User findById(Long id){
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:"+id+", Tipo: "+User.class.getName()));
	}

}
