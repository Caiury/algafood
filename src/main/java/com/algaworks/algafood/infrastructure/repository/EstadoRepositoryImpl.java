package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Estado> listarEstados() {
		return entityManager.createQuery("select Estado", Estado.class).getResultList();
	}

	@Override
	public Estado listarEstado(Long id) {
		return entityManager.find(Estado.class, id);
	}

	@Override
	public Estado salvar(Estado estado) {
		return entityManager.merge(estado);
	}

	@Override
	public void remover(Estado estado) {
		estado = listarEstado(estado.getId());
		entityManager.remove(estado);

	}

}
