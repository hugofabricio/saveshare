package br.com.fiap.saveshare.services;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fiap.saveshare.models.DadosBancariosUsuario;
import br.com.fiap.saveshare.models.Imovel;
import br.com.fiap.saveshare.models.ImovelComodidade;
import br.com.fiap.saveshare.models.ImovelDisponibilidade;
import br.com.fiap.saveshare.models.Reserva;
import br.com.fiap.saveshare.models.TipoImovel;
import br.com.fiap.saveshare.models.Usuario;
import br.com.fiap.saveshare.models.dto.NewImovelComodidadeDTO;
import br.com.fiap.saveshare.models.dto.NewImovelDTO;
import br.com.fiap.saveshare.models.dto.NewImovelDisponibilidadeDTO;
import br.com.fiap.saveshare.models.dto.NewReservaDTO;
import br.com.fiap.saveshare.models.enums.Perfil;
import br.com.fiap.saveshare.models.enums.TipoContaEnum;
import br.com.fiap.saveshare.repositories.TipoImovelRepository;

@Service
public class DBService {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TipoImovelRepository tipoImovelRepo;
	
	@Autowired
	private ImovelService imovelService;
	
	@Autowired
	private ImovelComodidadeService imovelComodidadeService;
	
	@Autowired
	private ImovelDisponibilidadeService disponibilidadeService;
	
	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public void instantiateTestDataBase() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfh = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		//Usuários
		
		TipoImovel tipo10 = new TipoImovel();
		tipo10.setTipoImovel("Psicologia");
		TipoImovel tipo11 = new TipoImovel();
		tipo11.setTipoImovel("Pilates");
		TipoImovel tipo12 = new TipoImovel();
		tipo12.setTipoImovel("Dentista");
		tipoImovelRepo.saveAll(Arrays.asList(tipo10, tipo11, tipo12));
		
		DadosBancariosUsuario dados = new DadosBancariosUsuario(null,"Itaú" , "123", "0001", TipoContaEnum.CORRENTE.getDescricao());
		DadosBancariosUsuario dados2 = new DadosBancariosUsuario(null,"Itaú" , "123", "0001", TipoContaEnum.CORRENTE.getDescricao());
		
		Usuario usuario1 = new Usuario(null, "Ana", "Almeida", "ana@gmail.com", passwordEncoder.encode("rosa1010"), "123456789", "37847803", sdf.parse("14/08/1987"), true, null);
		usuario1.addPerfil(Perfil.ADMIN);
		Usuario usuario2 = new Usuario(null, "Fabio", "Almeida", "fabio@gmail.com", passwordEncoder.encode("rosa1010"), "123456789", "37847803", sdf.parse("07/04/1987"), true, null);

		usuarioService.insert(usuario2, dados2);
		usuarioService.insert(usuario1, dados);
		
		//Imóveis
		
		NewImovelDTO imovelDTO = new NewImovelDTO();
		imovelDTO.setTitulo("Consultório");
		imovelDTO.setDescricao("Consultório completo com ótima localização!");
//		imovelDTO.setValorHora(new BigDecimal("100.00"));
		imovelDTO.setValorDia(new BigDecimal("300.00"));
//		imovelDTO.setValorSemana(new BigDecimal("1200.00"));
		imovelDTO.setCep("04578000");
		imovelDTO.setLogradouro("R das Margaridas");
		imovelDTO.setNumero("17");
		imovelDTO.setBairro("Jd das Flores");
		imovelDTO.setCidade("Uberlândia");
		imovelDTO.setUf("MG");
		imovelDTO.setIdUsuario(1);
		imovelDTO.setIdTipoImovel(1);
		
		Imovel imovel1 = imovelService.fromDTONewImovel(imovelDTO);
		imovelService.insert(imovel1);
		
		NewImovelDTO imovelDTO2 = new NewImovelDTO();
		imovelDTO2.setTitulo("Consultório 2");
		imovelDTO2.setDescricao("Espaço com equipamentos em perfeito estado");
//		imovelDTO2.setValorHora(new BigDecimal("100.00"));
		imovelDTO2.setValorDia(new BigDecimal("300.00"));
//		imovelDTO2.setValorSemana(new BigDecimal("1200.00"));
		imovelDTO2.setCep("03582000");
		imovelDTO2.setLogradouro("R das Camélias");
		imovelDTO2.setNumero("23");
		imovelDTO2.setBairro("Jd Silvestre");
		imovelDTO2.setCidade("Uberlândia");
		imovelDTO2.setUf("MG");
		imovelDTO2.setIdUsuario(1);
		imovelDTO2.setIdTipoImovel(2);
		
		Imovel imovel2 = imovelService.fromDTONewImovel(imovelDTO2);
		imovelService.insert(imovel2);
		
		NewImovelDTO imovelDTO3 = new NewImovelDTO();
		imovelDTO3.setTitulo("Consultório 3");
		imovelDTO3.setDescricao("Consultório novinho");
//		imovelDTO3.setValorHora(new BigDecimal("100.00"));
		imovelDTO3.setValorDia(new BigDecimal("300.00"));
//		imovelDTO3.setValorSemana(new BigDecimal("1200.00"));
		imovelDTO3.setCep("04582000");
		imovelDTO3.setLogradouro("R das Melancias");
		imovelDTO3.setNumero("33");
		imovelDTO3.setBairro("Jd da Fruta");
		imovelDTO3.setCidade("Uberlândia");
		imovelDTO3.setUf("MG");
		imovelDTO3.setIdUsuario(2);
		imovelDTO3.setIdTipoImovel(3);
		
		Imovel imovel3 = imovelService.fromDTONewImovel(imovelDTO3);
		imovelService.insert(imovel3);
		
		//Comodidades
		
		Imovel imovelt1 = imovelService.find(1);
		Imovel imovelt2 = imovelService.find(2);
		
		NewImovelComodidadeDTO comodidadedto1 = new NewImovelComodidadeDTO();
		comodidadedto1.setTitulo("comodidade 1");
		comodidadedto1.setIcone("ícone");
		comodidadedto1.setIdImovel(1);
		ImovelComodidade comodidade1 = imovelComodidadeService.fromDTONewComodidadeImovel(comodidadedto1, imovelt1);
		imovelComodidadeService.insert(comodidade1);
		
		NewImovelComodidadeDTO comodidadedto2 = new NewImovelComodidadeDTO();
		comodidadedto2.setTitulo("comodidade 2");
		comodidadedto2.setIcone("ícone");
		comodidadedto2.setIdImovel(1);
		ImovelComodidade comodidade2 = imovelComodidadeService.fromDTONewComodidadeImovel(comodidadedto2, imovelt1);
		imovelComodidadeService.insert(comodidade2);
		
		NewImovelComodidadeDTO comodidadedto3 = new NewImovelComodidadeDTO();
		comodidadedto3.setTitulo("comodidade 3");
		comodidadedto3.setIcone("ícone");
		comodidadedto3.setIdImovel(1);
		ImovelComodidade comodidade3 = imovelComodidadeService.fromDTONewComodidadeImovel(comodidadedto3, imovelt2);
		imovelComodidadeService.insert(comodidade3);
		
		//Disponiblidades
		
		NewImovelDisponibilidadeDTO disponibilidadeDto1 = new NewImovelDisponibilidadeDTO();
		disponibilidadeDto1.setHoraInicial(sdfh.parse("15/12/2020 10:00"));
		disponibilidadeDto1.setHoraFinal(sdfh.parse("15/12/2020 17:00"));
		ImovelDisponibilidade disponibilidade1 = disponibilidadeService.fromDTONewDisponibilidadeImovel(disponibilidadeDto1, imovelt1);
		disponibilidadeService.insert(disponibilidade1);
		
		NewImovelDisponibilidadeDTO disponibilidadeDto2 = new NewImovelDisponibilidadeDTO();
		disponibilidadeDto2.setHoraInicial(sdfh.parse("16/12/2020 10:00"));
		disponibilidadeDto2.setHoraFinal(sdfh.parse("16/12/2020 17:00"));
		ImovelDisponibilidade disponibilidade2 = disponibilidadeService.fromDTONewDisponibilidadeImovel(disponibilidadeDto2, imovelt1);
		disponibilidadeService.insert(disponibilidade2);
		
		NewImovelDisponibilidadeDTO disponibilidadeDto3 = new NewImovelDisponibilidadeDTO();
		disponibilidadeDto3.setHoraInicial(sdfh.parse("17/12/2020 10:00"));
		disponibilidadeDto3.setHoraFinal(sdfh.parse("17/12/2020 17:00"));
		ImovelDisponibilidade disponibilidade3 = disponibilidadeService.fromDTONewDisponibilidadeImovel(disponibilidadeDto3, imovelt2);
		disponibilidadeService.insert(disponibilidade3);
		
		//Reserva
		NewReservaDTO reservaDto = new NewReservaDTO();
		reservaDto.setIdDisponibilidade(1);
		reservaDto.setIdImovel(1);
		reservaDto.setIdUsuario(2);
		Reserva reserva = reservaService.fromDTONewReserva(reservaDto);
		reservaService.insert(reserva);
		
		
	}
	
}
