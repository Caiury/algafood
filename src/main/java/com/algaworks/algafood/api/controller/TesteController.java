package com.algaworks.algafood.api.controller;

import java.math.BigDecimal;
import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

//	@GetMapping("/cozinhas/por-nome")
//	Cozinha buscarPorNome(@RequestParam String nome){
//		return cozinhaRepository.findByNome(nome);

    @GetMapping("/cozinhas/por-nome")
    List<Cozinha> buscarNome(@RequestParam String nome) {
        return cozinhaRepository.findByNomeContaining(nome);
    }

    @GetMapping("/restaurante/por-taxa")
    List<Restaurante> buscarTaxa(@RequestParam BigDecimal taxaInicial , BigDecimal taxaFinal) {
        return restauranteRepository.findByTaxaFreteBetween(taxaInicial,taxaFinal);
    }

    @GetMapping("/restaurante/por-nome-e-taxa")
    List<Restaurante> buscarNomeTaxa(@RequestParam String nome, BigDecimal taxaInicial , BigDecimal taxaFinal) {
        return restauranteRepository.find(nome,taxaInicial,taxaFinal);
    }

    @GetMapping("/restaurante/por-nome")
    List<Restaurante> buscarNome(@RequestParam String nome, Long id) {
        return restauranteRepository.consultarPorNome(nome,id);
    }
//
//    @GetMapping("/restaurante/por-nome")
//    List<Restaurante> buscarNome(@RequestParam String nome, Long id) {
//        return restauranteRepository.findByNomeContainingAndCozinhaId(nome,id);
//    }



}
