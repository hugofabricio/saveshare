package br.com.fiap.saveshare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.saveshare.models.TipoImovel;
import br.com.fiap.saveshare.services.TipoImovelService;

@RestController
@RequestMapping(value = "tipos-imovel")
public class TipoImovelController {
	
	@Autowired
	private TipoImovelService service;
	
	@GetMapping(value = "{id}")
	public ResponseEntity<TipoImovel> find(@PathVariable Integer id){
		TipoImovel tipo = service.find(id);
		return ResponseEntity.ok().body(tipo);
	}
	
	@GetMapping
	public ResponseEntity<List<TipoImovel>> findAll(){
		List<TipoImovel> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
