package com.example.demo.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_perfil")
@Data
public class Perfil {

	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "perfil")
	private List<Usuario> usuarios;

}
