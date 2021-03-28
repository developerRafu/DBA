package com.rafu.testes.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rafu.testes.entities.Documento;
import com.rafu.testes.entities.User;
import com.rafu.testes.repositories.DocumentoRepository;
import com.rafu.testes.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DocumentoRepository documentoRepository;
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Rafu", "rafu@mail.com", "99999999", "9999999", "9999999");
		User u2 = new User(null, "Renan", "renan@mail.com", "99999999", "9999999", "9999999");
		Documento doc1 = new Documento(null, null, 0, u1);
		Documento doc2 = new Documento(null, null, 0, u2);
		u1.getListaDocs().addAll(Arrays.asList(doc1));
		u2.getListaDocs().addAll(Arrays.asList(doc2));
		this.userRepository.saveAll(Arrays.asList(u1,u2));
		this.documentoRepository.saveAll(Arrays.asList(doc1,doc2));
	}
	
	
	
}
