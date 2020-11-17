//package br.com.fiap.saveshare.services;
//
//import java.util.Random;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import br.com.fiap.saveshare.models.Usuario;
//import br.com.fiap.saveshare.repositories.UsuarioRepository;
//import br.com.fiap.saveshare.services.exceptions.ObjectNotFoundException;
//
//@Service
//public class AuthService {
//	
//	@Autowired
//	private UsuarioRepository usuarioRepository;
//	
//	@Autowired
//	private BCryptPasswordEncoder bCrypt;
//	
//	@Autowired
////	private EmailService emailService;
//	
//	private Random random = new Random();
//	
//	public void sendNewPassword(String email) {
//		Usuario usuario = usuarioRepository.findByEmail(email);
//		
//		if(usuario == null) {
//			throw new ObjectNotFoundException("Email não encontrado");
//		}
//		String newPassword = newPassword();
//		usuario.setSenha(bCrypt.encode(newPassword));
//		usuarioRepository.save(usuario);
////		emailService.sendNewPasswordEmail(usuario, newPassword);
//	}
//	
//	private String newPassword() {
//		char[] password = new char[10];
//		for(int i=0; i<10; i++) {
//			password[i] = randomChar();
//		}
//		return new String(password);
//	}
//	
//	private char randomChar() {
//		int opt = random.nextInt(3);
//		if(opt == 0) {//gera um dígito
//			//Foi buscado lá ba tabela unicode qual era o código do primeiro número de 0 a 9 (48 neste caso) para ser usado aqui
//			return(char)(random.nextInt(10) + 48); 
//		} else if(opt == 1 ) { // gera letra maiúscula
//			return(char) (random.nextInt(26) + 65);
//		} else {//gera letra minúscula
//			return(char)(random.nextInt(26) + 97);
//		}
//	}
//	
//}
