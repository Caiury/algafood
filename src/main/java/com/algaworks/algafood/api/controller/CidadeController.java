package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CadastroCidadeService cadastroCidadeService;

	@GetMapping
	public ResponseEntity<List<Cidade>> listar() {
		List<Cidade> cidades = cidadeRepository.findAll();
		return ResponseEntity.ok(cidades);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Cidade> listarCidade(@PathVariable Long id) {
		Cidade cidade = cidadeRepository.findById(id).orElse(null);

		if (cidade != null) {
			return ResponseEntity.ok(cidade);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Cidade cidade) {
		try {
			Cidade cidadeMerge = cadastroCidadeService.salvar(cidade);

			return ResponseEntity.status(HttpStatus.CREATED).body(cidadeMerge);

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Cidade cidade) {
		try {
			Cidade cidadeAtual = cidadeRepository.findById(id).orElse(null);

			if (cidadeAtual != null) {
				BeanUtils.copyProperties(cidade, cidadeAtual, "id");

				cadastroCidadeService.salvar(cidadeAtual);

				return ResponseEntity.ok(cidadeAtual);
			}
			return ResponseEntity.notFound().build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		try {
			cadastroCidadeService.excluir(id);
			return ResponseEntity.noContent().build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
