package com.treinar.sb.treinoSB.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	private String nome;
	@NotBlank
	private String usuario;
	@NotBlank
	private String email;
	@NotBlank
	private String senha;
	
	public Pessoa() {
		
	}

	public Pessoa(@NotBlank String nome, @NotBlank String email, @NotBlank String usuario, @NotBlank String senha) {
		super();
		this.nome = nome;
		this.usuario = usuario;
		this.email = email;
		this.senha = senha;
	}

	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
