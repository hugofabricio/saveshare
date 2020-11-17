package br.com.fiap.saveshare.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.saveshare.models.Imovel;
import br.com.fiap.saveshare.models.ImovelFoto;
import br.com.fiap.saveshare.models.dto.NewImovelDTO;
import br.com.fiap.saveshare.services.ImovelFotoService;
import br.com.fiap.saveshare.services.ImovelService;

@RestController
@RequestMapping(value = "imoveis")
public class ImovelController {
	
	@Autowired
	private ImovelService service;
	
	@Autowired
	private ImovelFotoService fotoService;
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Imovel> find(@PathVariable Integer id){
		Imovel imovel = service.find(id);
		return ResponseEntity.ok().body(imovel);
	}
	
	@GetMapping
	public ResponseEntity<List<Imovel>> findAll(){
		List<Imovel> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(
			@RequestBody NewImovelDTO dto){
		Imovel imovel = service.fromDTONewImovel(dto);
		imovel = service.insert(imovel);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(imovel.getIdImovel()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/usuario")
	public ResponseEntity<List<Imovel>> findImoveisByUsuario(@RequestParam(value="id")Integer idUsuario){
		List<Imovel> list = service.findImoveisByIdUsuario(idUsuario);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping(value = "/foto")
	public ResponseEntity<Void> uploadProfilePicture(
			@RequestParam(name = "foto") MultipartFile file,
			@RequestParam(name = "usuario") Integer idUsuario,
			@RequestParam(name = "imovel") Integer idImovel,
			@RequestParam(name= "legenda") String legenda) {
		
		ImovelFoto foto = fotoService.insert(file, legenda, idUsuario, idImovel);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("?id={id}").buildAndExpand(foto.getIdFotoImovel()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value = "/fotos")
	public ResponseEntity<List<ImovelFoto>> findFotosImovel(@RequestParam(value="id")Integer idImovel){
		List<ImovelFoto> list = fotoService.findFotosImovel(idImovel);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/foto")
	public ResponseEntity<ImovelFoto> findFoto(@RequestParam(value="id")Integer id){
		ImovelFoto foto = fotoService.find(id);
		return ResponseEntity.ok().body(foto);
	}

}
