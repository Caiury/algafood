package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
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
	@Transactional
	public Cidade salvar(Cidade cidade) {
		return entityManager.merge(cidade);
	}

	@Override
	@Transactional
	public void remover(Long cidadeId) {

		Cidade cidade = listarCidade(cidadeId);

		if (cidade == null) {

			throw new EmptyResultDataAccessException(1);
		}

		entityManager.remove(cidade);
	}

}
