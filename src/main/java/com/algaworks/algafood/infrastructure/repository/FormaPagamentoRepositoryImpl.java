package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<FormaPagamento> listarTodos() {
		TypedQuery<FormaPagamento> formaPagamentos = entityManager.createQuery("from FormaPagamento",
				FormaPagamento.class);
		return formaPagamentos.getResultList();
	}

	@Override
	public FormaPagamento listarFormaPagamento(Long id) {

		FormaPagamento formaPagamento = entityManager.find(FormaPagamento.class, id);
		return formaPagamento;
	}

	@Override
	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		formaPagamento = entityManager.merge(formaPagamento);
		return formaPagamento;
	}

	@Override
	public void deletar(FormaPagamento formaPagamento) {
		formaPagamento = listarFormaPagamento(formaPagamento.getId());

		entityManager.remove(formaPagamento);

	}

}
