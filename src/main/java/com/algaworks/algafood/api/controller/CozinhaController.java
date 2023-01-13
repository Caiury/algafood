package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

@RestController()
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired
	private CadastroCozinhaService cadastroCozinhaService;

	@GetMapping
	public ResponseEntity<List<Cozinha>> listarCozinhas() {

		List<Cozinha> cozinhas = cozinhaRepository.findAll();
		return ResponseEntity.ok().body(cozinhas);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> buscarCozinha(@PathVariable Long id) {

		Optional<Cozinha> cozinha = cozinhaRepository.findById(id);

		if (cozinha.isPresent()) {
			return ResponseEntity.ok(cozinha.get());

		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	ResponseEntity<Cozinha> salvar(@RequestBody Cozinha cozinha) {
		cadastroCozinhaService.salvar(cozinha);

		return ResponseEntity.status(HttpStatus.CREATED).body(cozinha);
	}

	@PutMapping("/{id}")
	ResponseEntity<Cozinha> atualizar(@PathVariable Long id, @RequestBody Cozinha cozinha) {

		Optional<Cozinha> cozinhaAtual = cozinhaRepository.findById(id);

		if (cozinhaAtual.isPresent()) {
			BeanUtils.copyProperties(cozinha, cozinhaAtual.get(), "id");

			cozinhaRepository.save(cozinhaAtual.get());

			return ResponseEntity.ok(cozinhaAtual.get());

		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	ResponseEntity<Cozinha> deletar(@PathVariable Long id) {
		try {

			cadastroCozinhaService.remover(id);

			return ResponseEntity.noContent().build();

		} catch (EntidadeEmUsoException e) {

			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
