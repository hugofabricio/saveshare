package br.com.fiap.saveshare.services;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.fiap.saveshare.models.Imovel;
import br.com.fiap.saveshare.models.TipoImovel;
import br.com.fiap.saveshare.models.Usuario;
import br.com.fiap.saveshare.models.dto.NewImovelDTO;
import br.com.fiap.saveshare.repositories.ImovelRepository;
import br.com.fiap.saveshare.services.exceptions.ObjectNotFoundException;

@Service
public class ImovelService {
	
	@Autowired
	private ImovelRepository repo;
	
	@Autowired
	private TipoImovelService tipoImovelService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	private TimeZone zone = TimeZone.getTimeZone("GMT-03:00");
	private Calendar date = Calendar.getInstance(zone, new Locale("pt-BR"));
	
	public Imovel fromDTONewImovel(NewImovelDTO dto) {
		Usuario usuario = usuarioService.find(dto.getIdUsuario());
		TipoImovel tipoImovel = tipoImovelService.find(dto.getIdTipoImovel());
		Imovel imovel = new Imovel(null, dto.getTitulo(), dto.getDescricao(), dto.getValorDia(), 
				null, dto.getCep(), dto.getLogradouro(), dto.getNumero(), dto.getComplemento(), dto.getBairro(), dto.getCidade(), dto.getUf(), 
				null, null, date.getTime(), null);
		imovel.setUsuario(usuario);
		imovel.setTipoImovel(tipoImovel);
		return imovel;
	}
	
	public Imovel insert(Imovel imovel) {
		imovel = repo.save(imovel);
		return imovel;
	}
	
	public List<Imovel> findAll(){
		return repo.findAll();
	}
	
	public List<Imovel> findImoveisByIdUsuario(Integer idUsuario){
		return repo.findImoveisByUsuario(idUsuario);
	}

	public Imovel find(Integer id) {
		Optional<Imovel> imovel = repo.findById(id);
		return imovel.orElseThrow(()-> new ObjectNotFoundException(
				"Imóvel não encontrado Id: " + id + ", Tipo: " + Imovel.class.getName()));
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir por que há reservas relacionadas");
		}
	}

}
