package br.com.fiap.saveshare.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.saveshare.models.Imovel;
import br.com.fiap.saveshare.models.ImovelComodidade;
import br.com.fiap.saveshare.models.dto.NewImovelComodidadeDTO;
import br.com.fiap.saveshare.services.ImovelComodidadeService;
import br.com.fiap.saveshare.services.ImovelService;

@RestController
@RequestMapping(value = "imoveis-comodidade")
public class ImovelComodidadeController {
	
	@Autowired
	private ImovelComodidadeService service;
	
	@Autowired
	private ImovelService imovelService;
	
	@GetMapping(value = "{id}")
	public ResponseEntity<ImovelComodidade> find(@PathVariable Integer id){
		ImovelComodidade comodidade = service.find(id);
		return ResponseEntity.ok().body(comodidade);
	}
	
	@GetMapping
	public ResponseEntity<List<ImovelComodidade>> findAll(){
		List<ImovelComodidade> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody NewImovelComodidadeDTO dto){
		Imovel imovel = imovelService.find(dto.getIdImovel());
		ImovelComodidade comodidade = service.fromDTONewComodidadeImovel(dto, imovel);
		comodidade = service.insert(comodidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(comodidade.getIdComodidade()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

}
