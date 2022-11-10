package com.algaworks.algafood.di.notificador;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Component
public class NotificadorEmail implements Notificador {

	
	@Override
	public void notificar (Cliente cliente, String mensagem) {
		
		
		System.out.println("Notificando cliente "+cliente.getNome()+" atraves do email "+cliente.getEmail()+
				":"+ mensagem);
	}

	
}
