package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Estado;

public interface EstadoRepository {

	
	public List<Estado>listarEstados();
	
	public Estado listarEstado(Long id);
	
	public Estado salvar(Estado estado);
	
	public void remover (Estado estado);
}
