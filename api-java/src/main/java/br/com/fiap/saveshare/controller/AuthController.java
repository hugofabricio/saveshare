//package br.com.fiap.saveshare.controller;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.fiap.saveshare.security.JWTUtil;
//import br.com.fiap.saveshare.security.UserSS;
//import br.com.fiap.saveshare.services.AuthService;
//import br.com.fiap.saveshare.services.UserService;
//
//@RestController
//@RequestMapping(value = "/auth")
//public class AuthController {
//
//	@Autowired
//	private JWTUtil jwtUtil;
//	
//	@Autowired
//	private AuthService authService;
//
//	@PostMapping(value = "/refresh_token")
//	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
//		UserSS user = UserService.authenticated();
//		String token = jwtUtil.generateToken(user.getUsername());
//		response.addHeader("Authorization", "Bearer " + token);
//		response.addHeader("access-control-expose-headers", "Authorization");
//		return ResponseEntity.noContent().build();
//	}
//	
////	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
////	public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO emailDto) {
////		authService.sendNewPassword(emailDto.getEmail());
////		return ResponseEntity.noContent().build();
////	}
//}
