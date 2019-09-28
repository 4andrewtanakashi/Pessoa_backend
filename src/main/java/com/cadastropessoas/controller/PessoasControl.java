package com.cadastropessoas.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cadastropessoas.models.Pessoa;
//import com.cadastropessoas.repository.PessoaRepository;
import com.cadastropessoas.service.PessoasService;

//@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
@RestController
public class PessoasControl {
	
//	@Autowired
//	private PessoaRepository pessoaRepos;
	
	@Autowired
	private PessoasService pesSiteServico;
	

	@GetMapping("/instructor/{username}/pessoas")
	public List<Pessoa> getTodasPes (@PathVariable String username) {
		System.out.print("username");
		System.out.print(username);
		System.out.println("\n\n");
		System.out.println("\n\n");

		return pesSiteServico.findAll();
	}
	

	@GetMapping("/instructor/{username}/pessoas/{id}")
	public Pessoa getPessoa(@PathVariable String username, @PathVariable long id) {
		return pesSiteServico.findById(id);
	}
	
	@GetMapping("/instructor/{username}/pessoas/nome/{palavra}")
	public List<Pessoa> getPessoaNome(@PathVariable String username, @PathVariable String palavra) {

		return pesSiteServico.findByName(palavra) ;
	}
	

	@DeleteMapping("/instructor/{username}/pessoas/{id}")
	public ResponseEntity<Void> deletePessoa (@PathVariable String username, @PathVariable long id) {
		
		Pessoa pessoa = pesSiteServico.deleteById(id);
		
		if (pessoa != null)
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.notFound().build();
	}
	
	@ResponseBody
	@PutMapping("/instructor/{username}/pessoas/{id}")
	public ResponseEntity<Pessoa> updatePesssoa (@PathVariable String username, @PathVariable long id, @RequestBody Pessoa pessoa) {
		System.out.println(id);
		System.out.println("\n\n");
		System.out.println("\n\n");
		Pessoa pessoaUpdate = pesSiteServico.salvar(pessoa);
	
		return new ResponseEntity<Pessoa>(pessoaUpdate, HttpStatus.OK);
	}
	
	@ResponseBody
	@PostMapping("/instructor/{username}/pessoas/{id}")
	public ResponseEntity<Void> criaPessoa (@PathVariable String username, @PathVariable long id, @RequestBody Pessoa pessoa) {
		System.out.println(id);
		System.out.println("\n\n");
		System.out.println("\n\n");
		Pessoa criaPes = pesSiteServico.salvar(pessoa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(criaPes.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
