package com.algaworks.algafood.di.modelo;

public class Cliente {
	
	private String nome;
	private String produto;
	private Integer telefone;
	private Boolean ativo = false;
	private String email;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void ativarCliente( ) {
		this.ativo = true;
	}
	

}
