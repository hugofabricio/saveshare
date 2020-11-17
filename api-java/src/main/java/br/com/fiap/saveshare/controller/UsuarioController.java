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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.saveshare.models.DadosBancariosUsuario;
import br.com.fiap.saveshare.models.Usuario;
import br.com.fiap.saveshare.models.dto.NewUsuarioDTO;
import br.com.fiap.saveshare.models.dto.UsuarioDTO;
import br.com.fiap.saveshare.services.UsuarioService;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Usuario> find(@PathVariable Integer id){
		Usuario usuario = service.find(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(
			@RequestBody NewUsuarioDTO dto){
		Usuario usuario = service.fromDTONewUsuario(dto);
		DadosBancariosUsuario dados = service.fromDTONewDadosBancarios(dto);
		usuario = service.insert(usuario, dados);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(usuario.getIdUsuario()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<Void> update(
			@PathVariable Integer id, 
			@RequestBody UsuarioDTO usuarioDTO){
		Usuario usuario = service.fromDTOUsuario(usuarioDTO);
		DadosBancariosUsuario dados = service.fromDTODadosBancarios(usuarioDTO);
		usuario = service.updateUsuario(usuario, dados);
		return ResponseEntity.noContent().build();
	}
	
	

}
