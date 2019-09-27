package com.cadastropessoas.cadastropessoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@PropertySource("classpath:application.properties")
@EntityScan("com.cadastropessoas.models")
@SpringBootApplication(scanBasePackages = {"com.cadastropessoas.controller", "com.cadastropessoas.service"})
@EnableJpaRepositories("com.cadastropessoas.repository")
public class CadastropessoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastropessoaApplication.class, args);
	}

}
