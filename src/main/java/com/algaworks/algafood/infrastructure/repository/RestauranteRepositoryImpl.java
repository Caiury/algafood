package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Restaurante> listarTodos() {

		TypedQuery<Restaurante> restaurantes = entityManager.createQuery("from Restaurante", Restaurante.class);
		return restaurantes.getResultList();
	}

	@Override
	public Restaurante listarRestaurante(Long id) {
		return entityManager.find(Restaurante.class, id);

	}

	@Transactional
	@Override
	public Restaurante salvar(Restaurante restaurante) {
		return entityManager.merge(restaurante);

	}

	@Override
	public void deletar(Restaurante restaurante) {

		restaurante = listarRestaurante(restaurante.getId());

		entityManager.remove(restaurante);
	}

}
