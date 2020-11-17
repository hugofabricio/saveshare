package br.com.fiap.saveshare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.saveshare.models.Imovel;
import br.com.fiap.saveshare.models.ImovelComodidade;
import br.com.fiap.saveshare.models.dto.NewImovelComodidadeDTO;
import br.com.fiap.saveshare.repositories.ImovelComodidadeRepository;
import br.com.fiap.saveshare.services.exceptions.ObjectNotFoundException;

@Service
public class ImovelComodidadeService {

	@Autowired
	private ImovelComodidadeRepository repo;

	public ImovelComodidade insert(ImovelComodidade imovelComodidade) {
		imovelComodidade = repo.save(imovelComodidade);
		return imovelComodidade;
	}

	public List<ImovelComodidade> findAll(){
		return repo.findAll();
	}

	public ImovelComodidade find(Integer id) {
		Optional<ImovelComodidade> imovelComodidade = repo.findById(id);
		return imovelComodidade.orElseThrow(()-> new ObjectNotFoundException(
				"Comodidade Imóvel não encontrada Id: " + id + ", Tipo: " + ImovelComodidade.class.getName()));
	}

	public ImovelComodidade fromDTONewComodidadeImovel(NewImovelComodidadeDTO dto, Imovel imovel) {
		ImovelComodidade comodidade = new ImovelComodidade(null, dto.getTitulo(), dto.getIcone(), imovel);

		return comodidade;
	}

}
