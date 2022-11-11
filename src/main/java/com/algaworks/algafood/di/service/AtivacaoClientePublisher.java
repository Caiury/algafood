package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.modelo.Cliente;

public class AtivacaoClientePublisher {

	private Cliente cliente;

	public AtivacaoClientePublisher(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
