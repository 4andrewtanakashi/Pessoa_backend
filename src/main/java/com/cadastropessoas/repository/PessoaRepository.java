package com.cadastropessoas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cadastropessoas.models.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
	

}
