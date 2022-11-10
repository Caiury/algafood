package com.algaworks.algafood;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.di.notificador.NotificadorEmail;

@Configuration
public class AlgaConfig {
	
	@Bean
	public NotificadorEmail notificadorEmail () {
		
		NotificadorEmail notificadorEmail = new NotificadorEmail("algafoof.smptp.com");
		notificadorEmail.setCaixaAlta(true);
		
		return notificadorEmail;
	}
	

}
