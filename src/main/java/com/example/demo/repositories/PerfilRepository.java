package com.example.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, UUID> {
	
	@Query("SELECT p FROM Perfil p WHERE p.nome = :nome")
	Perfil findByNome(@Param("nome") String nome);
	
}
