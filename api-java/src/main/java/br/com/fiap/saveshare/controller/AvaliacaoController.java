package br.com.fiap.saveshare.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.saveshare.models.Avaliacao;
import br.com.fiap.saveshare.models.dto.AvaliacaoDTO;
import br.com.fiap.saveshare.services.AvaliacaoService;

@RestController
@RequestMapping(value = "avaliacao")
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoService service;
	
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody AvaliacaoDTO dto){
		Avaliacao avaliacao = service.validaAvaliacao(dto);
		avaliacao = service.insert(avaliacao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(avaliacao.getIdAvaliacao()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@GetMapping(value = "/usuario")
	public ResponseEntity<List<Avaliacao>> findAvaliacoesByUsuario(@RequestParam(value="id")Integer idUsuario){
		List<Avaliacao> list = service.listaAvaliacoesUsuario(idUsuario);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/imovel")
	public ResponseEntity<List<Avaliacao>> findAvaliacoesByImovel(@RequestParam(value="id")Integer idImovel){
		List<Avaliacao> list = service.listaAvaliacoesImovel(idImovel);
		return ResponseEntity.ok().body(list);
	}

}
