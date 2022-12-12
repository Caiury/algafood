package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Permissao> listarPermissoes() {
		return entityManager.createQuery("from Permissao", Permissao.class).getResultList();
	}

	@Override
	public Permissao listarPermissao(Long id) {
		return entityManager.find(Permissao.class, id);
	}

	@Override
	public Permissao salvarPermissao(Permissao permissao) {
		return entityManager.merge(permissao);
	}

	@Override
	public void remover(Permissao permissao) {

		permissao = listarPermissao(permissao.getId());

		entityManager.remove(permissao);
	}

}
