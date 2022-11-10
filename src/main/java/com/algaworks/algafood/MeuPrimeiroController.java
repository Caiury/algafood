package com.algaworks.algafood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.service.AtivacaoClienteService;

@Controller
public class MeuPrimeiroController {
	
	private AtivacaoClienteService ativacaoClienteService;
	
	public MeuPrimeiroController(AtivacaoClienteService ativacaoClienteService) {
		this.ativacaoClienteService = ativacaoClienteService;
	}
	
	
	@GetMapping("/ola")
	@ResponseBody
	public String controller() {
		Cliente cliente = new Cliente();
		cliente.setNome("João");
		cliente.setTelefone(1195229352);
		cliente.setEmail("jdssdhh@gmail.com");
		
		ativacaoClienteService.AtivarCliente(cliente);
		
		return "Olá";
	}

}
