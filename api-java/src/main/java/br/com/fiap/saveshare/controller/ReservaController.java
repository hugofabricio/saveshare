package br.com.fiap.saveshare.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.saveshare.models.Reserva;
import br.com.fiap.saveshare.models.dto.NewReservaDTO;
import br.com.fiap.saveshare.services.ImovelDisponibilidadeService;
import br.com.fiap.saveshare.services.ReservaService;

@RestController
@RequestMapping(value = "reservas")
public class ReservaController {
	
	@Autowired
	private ReservaService service;
	
	@Autowired
	private ImovelDisponibilidadeService disponibilidadeService;
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Reserva> find(@PathVariable Integer id){
		Reserva reserva = service.find(id);
		return ResponseEntity.ok().body(reserva);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody NewReservaDTO dto){
		disponibilidadeService.atualizaDisponibilidade(dto.getIdDisponibilidade(), false);
		Reserva reserva = service.fromDTONewReserva(dto);
		reserva = service.insert(reserva);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(reserva.getIdReserva()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<Void> cancela(@PathVariable Integer id){
		service.cancela(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/usuario")
	public ResponseEntity<List<Reserva>> findReservasByIdUsuario(@RequestParam(value="id")Integer idUsuario){
		List<Reserva> list = service.findReservasByIdUsuario(idUsuario);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	public ResponseEntity<Page<Reserva>> findPage(
			@RequestParam(value="page", defaultValue="0")Integer page,
			@RequestParam(value="linesPerPage", defaultValue="24")Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="idReserva")String orderBy,
			@RequestParam(value="direction", defaultValue="DESC")String direction){
		Page<Reserva> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}

}
