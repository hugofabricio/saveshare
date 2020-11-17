package br.com.fiap.saveshare.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.fiap.saveshare.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			//método do Spring que retorna o usuário que estiver logado no sistema
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}

	}
	
}
