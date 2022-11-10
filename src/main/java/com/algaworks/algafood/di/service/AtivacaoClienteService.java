package com.algaworks.algafood.di.service;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificador.Notificador;

@Component
public class AtivacaoClienteService {
	
	private Notificador notificadorEmail;
	
	public AtivacaoClienteService(Notificador notificadorEmail) {
		this.notificadorEmail =notificadorEmail;
	}

	
	public void AtivarCliente(Cliente cliente) {
	
		cliente.ativarCliente();
		
		notificadorEmail.notificar(cliente, "Cliente está ativo");
	}
}
