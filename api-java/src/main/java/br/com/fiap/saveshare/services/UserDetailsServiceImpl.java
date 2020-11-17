package br.com.fiap.saveshare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fiap.saveshare.models.Usuario;
import br.com.fiap.saveshare.repositories.UsuarioRepository;
import br.com.fiap.saveshare.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = repo.findByEmail(email);
		if (usuario == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(usuario.getIdUsuario(), usuario.getEmail(), usuario.getSenha(), usuario.getPerfis());
	}

}
