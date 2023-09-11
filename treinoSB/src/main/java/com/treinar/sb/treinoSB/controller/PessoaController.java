package com.treinar.sb.treinoSB.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinar.sb.treinoSB.entities.Pessoa;
import com.treinar.sb.treinoSB.repositories.PessoaRepository;

@RestController
@RequestMapping(path = "/api/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@PostMapping
	public ResponseEntity<?> criarPessoa(Pessoa pessoas) {
		Optional<Pessoa> existeNomePessoa = pessoaRepository.findByNome(pessoas.getNome());
		Optional<Pessoa> existeEmailPessoa = pessoaRepository.findByNome(pessoas.getEmail());
		Optional<Pessoa> existeUsuarioPessoa = pessoaRepository.findByNome(pessoas.getUsuario());
		if(existeNomePessoa.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao adicionar a pessoa, nome já existente.");
		}
		if(existeEmailPessoa.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao adicionar a pessoa, email já existente.");
		}
		if(existeUsuarioPessoa.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao adicionar a pessoa, usuário já existente.");
		}
		Pessoa novaPessoa = pessoaRepository.save(pessoas);
		return ResponseEntity.status(HttpStatus.CREATED).body("Nova pessoa criada com sucesso.");
	}
	
	@GetMapping(path = "/todos")
	public List<Pessoa> obterTodasPessoas() {
		return pessoaRepository.findAll();
	}
	
	@GetMapping(path = "/{parteNome}")
	public Iterable<Pessoa> obterPessoasNome(@PathVariable String parteNome){
		return pessoaRepository.findByNomeContainingIgnoreCase(parteNome);
	}
	
	@PutMapping()
	public ResponseEntity<?> alterarUsuario(Pessoa pessoas){
		Optional<Pessoa> existeNomePessoa = pessoaRepository.findByNome(pessoas.getNome());
		Optional<Pessoa> existeEmailPessoa = pessoaRepository.findByEmail(pessoas.getEmail());
		Optional<Pessoa> existeUsuarioPessoa = pessoaRepository.findByUsuario(pessoas.getUsuario());
		if(existeNomePessoa.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome já existente.");
		}
		else if(existeEmailPessoa.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail já existente. ");
		}
		else if(existeUsuarioPessoa.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário já existente.");
		}
		else {
			Pessoa editarPessoa = pessoaRepository.save(pessoas);
			return ResponseEntity.status(HttpStatus.CREATED).body("Informações atualizadas com sucesso.");
		}
	}
	
	@DeleteMapping(path = "/deletar/{id}")
	public ResponseEntity<?> deletarPessoa(@PathVariable int id){
		try {
			pessoaRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Id " +id + " deletado com sucesso.");
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Id inexistente.");
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar o ID.");
		}
		
	}
	
	

}
