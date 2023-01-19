package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RestauranteRepositoryQueries {

    List<Restaurante> find(String nome , BigDecimal taxaInicial, BigDecimal taxaFinal);
}
