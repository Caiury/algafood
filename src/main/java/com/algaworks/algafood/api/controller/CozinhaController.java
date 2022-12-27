package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@RestController()
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@GetMapping
	public ResponseEntity<List<Cozinha>> listarCozinhas() {

		List<Cozinha> cozinhas = cozinhaRepository.listarCozinhas();
		return ResponseEntity.ok().body(cozinhas);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> buscarCozinha(@PathVariable Long id) {

		Cozinha cozinha = cozinhaRepository.buscarCozinha(id);

		if (cozinha != null) {
			return ResponseEntity.ok(cozinha);

		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	ResponseEntity<Cozinha> salvar(@RequestBody Cozinha cozinha) {
		Cozinha cozinhaMerge = cozinhaRepository.salvar(cozinha);

		return ResponseEntity.status(HttpStatus.CREATED).body(cozinha);
	}

}
