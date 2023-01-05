package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;

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

	@PutMapping("/{id}")
	ResponseEntity<Cozinha> atualizar(@PathVariable Long id, @RequestBody Cozinha cozinha) {

		Cozinha cozinhaAtual = cozinhaRepository.buscarCozinha(id);

		if (cozinhaAtual != null) {
			BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");

			cozinhaRepository.salvar(cozinhaAtual);

			return ResponseEntity.ok(cozinhaAtual);

		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	ResponseEntity<Cozinha> deletar(@PathVariable Long id) {
		try {
			Cozinha cozinha = cozinhaRepository.buscarCozinha(id);

			if (cozinha != null) {
				cozinhaRepository.remover(cozinha);

				return ResponseEntity.noContent().build();
			}

			return ResponseEntity.notFound().build();
		} catch (DataIntegrityViolationException e) {

			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
