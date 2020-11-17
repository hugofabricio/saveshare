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
import br.com.fiap.saveshare.models.ImovelDisponibilidade;
import br.com.fiap.saveshare.models.dto.NewImovelDisponibilidadeDTO;
import br.com.fiap.saveshare.services.ImovelDisponibilidadeService;
import br.com.fiap.saveshare.services.ImovelService;

@RestController
@RequestMapping(value = "imoveis-disponibilidade")
public class ImovelDisponibilidadeController {
	
	@Autowired
	private ImovelDisponibilidadeService service;
	
	@Autowired
	private ImovelService imovelService;
	
	@GetMapping(value = "{id}")
	public ResponseEntity<ImovelDisponibilidade> find(@PathVariable Integer id){
		ImovelDisponibilidade disponibilidade = service.find(id);
		return ResponseEntity.ok().body(disponibilidade);
	}
	
	@GetMapping
	public ResponseEntity<List<ImovelDisponibilidade>> findAll(){
		List<ImovelDisponibilidade> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody NewImovelDisponibilidadeDTO dto){
		Imovel imovel = imovelService.find(dto.getIdImovel());
		ImovelDisponibilidade imovelDisponibilidade = service.fromDTONewDisponibilidadeImovel(dto, imovel);
		imovelDisponibilidade = service.insert(imovelDisponibilidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(imovelDisponibilidade.getIdDisponibilidade()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

}
