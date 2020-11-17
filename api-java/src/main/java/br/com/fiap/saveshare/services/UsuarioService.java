package br.com.fiap.saveshare.services;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.TimeZone;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fiap.saveshare.models.DadosBancariosUsuario;
import br.com.fiap.saveshare.models.Usuario;
import br.com.fiap.saveshare.models.dto.NewUsuarioDTO;
import br.com.fiap.saveshare.models.dto.UsuarioDTO;
import br.com.fiap.saveshare.repositories.DadosBancariosUsuarioRepository;
import br.com.fiap.saveshare.repositories.UsuarioRepository;
import br.com.fiap.saveshare.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repo;
	
	@Autowired
	DadosBancariosUsuarioRepository repoDadosBancarios;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private TimeZone zone = TimeZone.getTimeZone("GMT-03:00");
	private Calendar date = Calendar.getInstance(zone, new Locale("pt-BR"));

	public Usuario insert(Usuario usuario, DadosBancariosUsuario dadosBancarios) {
		usuario.setIdUsuario(null);
		usuario.setDataCadastro(date.getTime());
		usuario = repo.save(usuario);
		dadosBancarios.setIdUsuario(usuario.getIdUsuario());
		repoDadosBancarios.save(dadosBancarios);
		return usuario;
	}

	public List<Usuario> findAll(){
		return repo.findAll();
	}

	public Usuario find(Integer id) {
		Optional<Usuario> usuario = repo.findById(id);
		return usuario.orElseThrow(()-> new ObjectNotFoundException(
				"Usuário não encontrado Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
			repoDadosBancarios.deleteById(repoDadosBancarios.findByIdUsuario(id).getIdDadosBancarios());
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir por que há reservas relacionadas");
		}

	}
	
	
	public Usuario fromDTOUsuario(UsuarioDTO dto) {
		Usuario usuario = new Usuario(dto.getIdUsuario(), dto.getNome(), dto.getSobrenome(), 
				null, null, null, dto.getTelefone(), dto.getDataNascimento(), true, null);
		return usuario;
	}
	
	public Usuario fromDTONewUsuario(NewUsuarioDTO dto) {
		Usuario usuario = new Usuario(null, dto.getNome(), dto.getSobrenome(), 
				dto.getEmail(), passwordEncoder.encode(dto.getSenha()), dto.getCpf(), dto.getTelefone(), dto.getDataNascimento(), true, null);
		return usuario;
	}
	
	public DadosBancariosUsuario fromDTONewDadosBancarios(NewUsuarioDTO dto) {
		DadosBancariosUsuario dados = new DadosBancariosUsuario(null, dto.getBanco(), dto.getAgencia(), dto.getConta(), dto.getTipoConta());
		return dados;
	}
	
	public DadosBancariosUsuario fromDTODadosBancarios(UsuarioDTO dto) {
		DadosBancariosUsuario dados = new DadosBancariosUsuario((repoDadosBancarios.findByIdUsuario(dto.getIdUsuario())).getIdDadosBancarios(), dto.getBanco(), dto.getAgencia(), dto.getConta(), dto.getTipoConta());
		return dados;
	}
	
	public void updateData(Usuario newUsuario, Usuario usuario, DadosBancariosUsuario newDados, DadosBancariosUsuario dados) {
		newUsuario.setNome(usuario.getNome());
		newUsuario.setSobrenome(usuario.getSobrenome());
		newUsuario.setTelefone(usuario.getTelefone());
		newUsuario.setDataNascimento(usuario.getDataNascimento());
		newUsuario.setDataUltimaAtualizacao(date.getTime());
		
		newDados.setAgencia(dados.getAgencia());
		newDados.setBanco(dados.getBanco());
		newDados.setConta(dados.getConta());
		newDados.setTipoConta(dados.getTipoConta());
	}
	
	@Transactional
	public Usuario updateUsuario(Usuario usuario, DadosBancariosUsuario dados) {
		Usuario newUsuario = find(usuario.getIdUsuario());
		DadosBancariosUsuario newDados = repoDadosBancarios.findByIdUsuario(usuario.getIdUsuario());
		updateData(newUsuario, usuario, newDados, dados);
		repoDadosBancarios.save(newDados);
		return repo.save(newUsuario);
		
	}
	
}
