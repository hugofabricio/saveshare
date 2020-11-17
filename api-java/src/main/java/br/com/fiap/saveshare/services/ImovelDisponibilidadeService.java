package br.com.fiap.saveshare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.saveshare.models.Imovel;
import br.com.fiap.saveshare.models.ImovelDisponibilidade;
import br.com.fiap.saveshare.models.dto.NewImovelDisponibilidadeDTO;
import br.com.fiap.saveshare.repositories.ImovelDisponibilidadeRepository;
import br.com.fiap.saveshare.services.exceptions.ObjectNotFoundException;

@Service
public class ImovelDisponibilidadeService {

	@Autowired
	private ImovelDisponibilidadeRepository repo;

	public ImovelDisponibilidade insert(ImovelDisponibilidade imovelDisponibilidade) {
		imovelDisponibilidade = repo.save(imovelDisponibilidade);
		return imovelDisponibilidade;
	}

	public List<ImovelDisponibilidade> findAll(){
		return repo.findAll();
	}

	public ImovelDisponibilidade find(Integer id) {
		Optional<ImovelDisponibilidade> imovelDisponibilidade = repo.findById(id);
		return imovelDisponibilidade.orElseThrow(()-> new ObjectNotFoundException(
				"Disponibilidade Imóvel não encontrada Id: " + id + ", Tipo: " + ImovelDisponibilidade.class.getName()));
	}

	public ImovelDisponibilidade fromDTONewDisponibilidadeImovel(NewImovelDisponibilidadeDTO dto, Imovel imovel) {
		ImovelDisponibilidade disponiblidade = new ImovelDisponibilidade(null, dto.getHoraInicial(), dto.getHoraFinal(), imovel, true);

		return disponiblidade;
	}
	
	public void atualizaDisponibilidade(Integer idDisponibilidade, Boolean status) {
		ImovelDisponibilidade disponibilidade = find(idDisponibilidade);
		disponibilidade.setStatus(status);
		repo.save(disponibilidade);
	}

}
