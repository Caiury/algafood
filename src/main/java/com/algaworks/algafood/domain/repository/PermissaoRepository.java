package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Permissao;

public interface PermissaoRepository {

	public List<Permissao> listarPermissoes();

	public Permissao listarPermissao(Long id);

	public Permissao salvarPermissao(Permissao permissao);

	public void remover(Permissao permissao);

}
