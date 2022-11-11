package com.algaworks.algafood.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.notificador.Notificador;
import com.algaworks.algafood.di.notificador.TipoNotificadorAnotacao;
import com.algaworks.algafood.di.notificador.TiposNotificador;
import com.algaworks.algafood.di.service.AtivacaoClientePublisher;

@Component
public class AtivacaoClienteListener {

	@Autowired
	@TipoNotificadorAnotacao(TiposNotificador.NORMAL)
	private Notificador notificador;

	@EventListener
	public void ativacaoClienteListener(AtivacaoClientePublisher cliente) {

		notificador.notificar(cliente.getCliente(), "Cliente está ativo");
	}

}
