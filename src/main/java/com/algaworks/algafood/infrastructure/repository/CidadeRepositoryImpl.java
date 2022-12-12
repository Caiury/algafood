package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Cidade> listarCidades() {
		return entityManager.createQuery("from Cidade", Cidade.class).getResultList();
	}

	@Override
	public Cidade listarCidade(Long id) {
		return entityManager.find(Cidade.class, id);
	}

	@Override
	public Cidade salvar(Cidade cidade) {
		return entityManager.merge(cidade);
	}

	@Override
	public void remover(Cidade cidade) {

		cidade = listarCidade(cidade.getId());

		entityManager.remove(cidade);
	}

}
