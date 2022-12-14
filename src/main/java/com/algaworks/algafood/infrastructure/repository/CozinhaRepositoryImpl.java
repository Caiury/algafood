package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Cozinha> listarCozinhas() {

		TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);

		return query.getResultList();
	}

	@Override
	public Cozinha buscarCozinha(Long id) {
		return manager.find(Cozinha.class, id);
	}

	@Transactional
	@Override
	public Cozinha salvar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}

	@Transactional
	@Override
	public void remover(Long cozinhaId) {
		Cozinha cozinha = buscarCozinha(cozinhaId);
		if (cozinha == null) {
			throw new EmptyResultDataAccessException(1);
		}

		manager.remove(cozinha);
	}

	@Override
	public List<Cozinha> buscarPorNome(String nome) {
		return manager.createQuery("from Cozinha where nome like :nome", Cozinha.class)
				.setParameter("nome", "%" + nome+ "%").getResultList();
	}

}
