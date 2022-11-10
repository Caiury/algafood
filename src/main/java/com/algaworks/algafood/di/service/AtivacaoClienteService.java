package com.algaworks.algafood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificador.Notificador;

@Component
public class AtivacaoClienteService {
	
	@Autowired(required = false)
	private Notificador notificadorEmail;
	
	
	public void AtivarCliente(Cliente cliente) {
	
		cliente.ativarCliente();
		
		if(notificadorEmail != null) {
			notificadorEmail.notificar(cliente, "Cliente está ativo");
		}else {
			
			System.out.println("Não existe notificador mas cliente foi ativado");
		}
		
		
	}
}
