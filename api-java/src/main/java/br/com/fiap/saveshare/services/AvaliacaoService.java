package br.com.fiap.saveshare.services;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.saveshare.models.Avaliacao;
import br.com.fiap.saveshare.models.Reserva;
import br.com.fiap.saveshare.models.Usuario;
import br.com.fiap.saveshare.models.dto.AvaliacaoDTO;
import br.com.fiap.saveshare.models.enums.TipoUsuarioEnum;
import br.com.fiap.saveshare.repositories.AvaliacaoRepository;
import br.com.fiap.saveshare.services.exceptions.AuthorizationException;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository repo;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private br.com.fiap.saveshare.repositories.AvaliacaoDao dao;
	
	private TimeZone zone = TimeZone.getTimeZone("GMT-03:00");
	private Calendar date = Calendar.getInstance(zone, new Locale("pt-BR"));

	public Avaliacao insert(Avaliacao avaliacao) {
		avaliacao = repo.save(avaliacao);
		Reserva reserva = avaliacao.getReserva();
		reserva.setAvaliacao(avaliacao);
		reservaService.insert(reserva);
		return avaliacao;
	}

	public List<Avaliacao> listaAvaliacoesImovel(Integer idImovel){
		return dao.listaAvaliacoesImovel(idImovel);
	}
	
	public List<Avaliacao> listaAvaliacoesUsuario(Integer idUsuario){
		return dao.listaAvaliacoesUsuario(idUsuario);
	}
	
	public Avaliacao validaAvaliacao(AvaliacaoDTO dto) {
		Usuario usuarioLogado = usuarioService.find(dto.getIdUsuario());
		Reserva reserva = reservaService.find(dto.getIdReserva());
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setIdAvaliacao(null);
		avaliacao.setComentario(dto.getComentario());
		avaliacao.setNota(dto.getNota());
		avaliacao.setCriacao(date.getTime());
		avaliacao.setReserva(reserva);
		avaliacao.setUsuario(usuarioLogado);
		if(usuarioLogado.equals(reserva.getImovel().getUsuario())) {
			avaliacao.setTipoUsuario(TipoUsuarioEnum.LOCADOR.getDescricao());
			return avaliacao;
		}else if(usuarioLogado.equals(reserva.getUsuario())) {
			avaliacao.setTipoUsuario(TipoUsuarioEnum.LOCATARIO.getDescricao());
			return avaliacao;
		}else {
			throw new AuthorizationException("Avaliação permitida somente ao locador e ao locatário");
		}
	}
	

}
