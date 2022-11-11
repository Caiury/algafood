package com.algaworks.algafood.di.notificador;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@TipoNotificadorAnotacao(TiposNotificador.NORMAL)
@Component
public class NotificadorEmail implements Notificador {

	@Override
	public void notificar(Cliente cliente, String mensagem) {

		System.out.println("Notificando cliente " + cliente.getNome() + " atraves do email " + cliente.getEmail() + ":"
				+ mensagem);
	}

}
