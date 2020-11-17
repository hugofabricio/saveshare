package br.com.fiap.saveshare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.fiap.saveshare.models.Imovel;
import br.com.fiap.saveshare.models.ImovelDisponibilidade;
import br.com.fiap.saveshare.models.Reserva;
import br.com.fiap.saveshare.models.Usuario;
import br.com.fiap.saveshare.models.dto.NewReservaDTO;
import br.com.fiap.saveshare.repositories.ReservaRepository;
import br.com.fiap.saveshare.security.UserSS;
import br.com.fiap.saveshare.services.exceptions.AuthorizationException;
import br.com.fiap.saveshare.services.exceptions.ObjectNotFoundException;

@Service
public class ReservaService {

	@Autowired
	private ReservaRepository repo;
	
	@Autowired
	private ImovelService imovelService;
	
	@Autowired
	private ImovelDisponibilidadeService imovelDisponilidadeService;
	
	@Autowired
	private UsuarioService usuarioService;

	public Reserva insert(Reserva reserva) {
		reserva = repo.save(reserva);
		return reserva;
	}

	public List<Reserva> findAll(){
		return repo.findAll();
	}

	public Reserva find(Integer id) {
		Optional<Reserva> reserva = repo.findById(id);
		return reserva.orElseThrow(()-> new ObjectNotFoundException(
				"Reserva não encontrada Id: " + id + ", Tipo: " + Reserva.class.getName()));
	}

	public Reserva fromDTONewReserva(NewReservaDTO dto) {
		Usuario usuario = usuarioService.find(dto.getIdUsuario());
		Imovel imovel = imovelService.find(dto.getIdImovel());
		ImovelDisponibilidade disponibilidade = imovelDisponilidadeService.find(dto.getIdDisponibilidade());
		Reserva reserva = new Reserva(null, imovel, usuario, true, disponibilidade);

		return reserva;
	}
	
	public List<Reserva> findReservasByIdUsuario(Integer idUsuario){
		return repo.findReservasByUsuario(idUsuario);
	}
	
	public void cancela(Integer idReserva) {
		Reserva reserva = find(idReserva);
		reserva.setStatus(false);
		imovelDisponilidadeService.atualizaDisponibilidade(reserva.getImovelDisponibilidade().getIdDisponibilidade(), true);
		repo.save(reserva);
	}
	
	public Page<Reserva> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		UserSS user = UserService.authenticated();
		if (user==null ) {
			throw new AuthorizationException("Acesso negado");
		}
		Usuario usuario = usuarioService.find(user.getId());
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		System.out.println(usuario);
		return repo.findByUsuario(usuario, pageRequest);

	}

}
