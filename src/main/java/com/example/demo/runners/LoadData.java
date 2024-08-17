package com.example.demo.runners;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Perfil;
import com.example.demo.repositories.PerfilRepository;

@Component
public class LoadData implements ApplicationRunner {

	@Autowired
	private PerfilRepository perfilRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Perfil perfil_default = new Perfil();
		perfil_default.setId(UUID.randomUUID());
		perfil_default.setNome("DEFAULT");
		
		
		Perfil perfil_admin = new Perfil();
		perfil_default.setId(UUID.randomUUID());
		perfil_default.setNome("ADMIN");
		
		if(perfilRepository.findByNome("DEFAULT") == null)
			perfilRepository.save(perfil_default);
		
		if(perfilRepository.findByNome("ADMIN") == null)
			perfilRepository.save(perfil_admin);
		
	}

}
