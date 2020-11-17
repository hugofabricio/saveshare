package br.com.fiap.saveshare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.saveshare.models.DadosBancariosUsuario;
import br.com.fiap.saveshare.repositories.DadosBancariosUsuarioRepository;

@Service
public class DadosBancariosService {

	@Autowired
	private DadosBancariosUsuarioRepository repo;
	
	public List<DadosBancariosUsuario> findAll(){
		return repo.findAll();
	}

	public DadosBancariosUsuario findByIdUsuario(Integer id) {
		return repo.findByIdUsuario(id);
	}
}
