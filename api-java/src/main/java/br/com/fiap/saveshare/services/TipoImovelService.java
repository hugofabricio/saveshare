package br.com.fiap.saveshare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.saveshare.models.TipoImovel;
import br.com.fiap.saveshare.repositories.TipoImovelRepository;
import br.com.fiap.saveshare.services.exceptions.ObjectNotFoundException;

@Service
public class TipoImovelService {
	
	@Autowired
	private TipoImovelRepository repo;
	
	public List<TipoImovel> findAll () {
		return repo.findAll();
	}
	
	public TipoImovel find (Integer id) {
		Optional<TipoImovel> tipo = repo.findById(id);
		return tipo.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + ", Tipo: " + TipoImovel.class.getName()));
	}

}
