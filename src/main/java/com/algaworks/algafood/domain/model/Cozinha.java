package com.algaworks.algafood.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cozinha {
	
	@Id
	private Long id;
	
	private String nomeCozinha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCozinha() {
		return nomeCozinha;
	}

	public void setNomeCozinha(String nomeCozinha) {
		this.nomeCozinha = nomeCozinha;
	}
	
	

}
