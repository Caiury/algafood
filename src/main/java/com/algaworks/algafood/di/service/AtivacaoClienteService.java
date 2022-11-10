package com.algaworks.algafood.di.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificador.Notificador;
import com.algaworks.algafood.di.notificador.TipoNotificadorAnotacao;
import com.algaworks.algafood.di.notificador.TiposNotificador;

@Component
public class AtivacaoClienteService {
	
	@TipoNotificadorAnotacao(TiposNotificador.URGENTE)
	@Autowired()
	private Notificador notificador;
	
	
	public void AtivarCliente(Cliente cliente) {
	
		cliente.ativarCliente();
		
			notificador.notificar(cliente, "Cliente está ativo");
		
	}
}
