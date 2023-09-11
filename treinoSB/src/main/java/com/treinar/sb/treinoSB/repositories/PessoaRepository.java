package com.treinar.sb.treinoSB.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinar.sb.treinoSB.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
	Optional<Pessoa> findByNome(String nome);
	Optional<Pessoa> findByUsuario(String usuario);
	Optional<Pessoa> findByEmail(String email);
	Iterable<Pessoa> findByNomeContainingIgnoreCase(String parteNome);
	Iterable<Pessoa> findByUsuarioContainingIgnoreCase(String parteUsuario);
	Iterable<Pessoa> findByEmailContainingIgnoreCase(String parteEmail);

}
