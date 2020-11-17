package br.com.fiap.saveshare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.saveshare.models.DadosBancariosUsuario;

public interface DadosBancariosUsuarioRepository extends JpaRepository<DadosBancariosUsuario, Integer>{
	
	DadosBancariosUsuario findByIdUsuario(Integer idUsuario);

}
