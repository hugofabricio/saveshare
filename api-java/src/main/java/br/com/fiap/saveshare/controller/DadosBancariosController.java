package br.com.fiap.saveshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.saveshare.models.DadosBancariosUsuario;
import br.com.fiap.saveshare.services.DadosBancariosService;

@RestController
@RequestMapping(value = "dados-bancarios")
public class DadosBancariosController {
	
	@Autowired
	private DadosBancariosService service;
	
	@GetMapping(value = "{id}")
	public ResponseEntity<DadosBancariosUsuario> find(@PathVariable Integer id){
		DadosBancariosUsuario dados = service.findByIdUsuario(id);
		return ResponseEntity.ok().body(dados);
	}
}
