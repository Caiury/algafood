package com.algaworks.algafood.di.notificador;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

public class NotificadorEmail implements Notificador {

	private Boolean caixaAlta;
	private String hostServidorSmtp;
	
	public NotificadorEmail (String hostServidorSmptp) {
		
		this.hostServidorSmtp = hostServidorSmptp;
	}
	
	@Override
	public void notificar (Cliente cliente, String mensagem) {
		
		if (caixaAlta) {
			mensagem = mensagem.toUpperCase();
		}
		
		System.out.println("Notificando cliente "+cliente.getNome()+" atraves do email "+cliente.getEmail()+
				":"+ mensagem);
	}

	public void setCaixaAlta(Boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}
	
	
}
