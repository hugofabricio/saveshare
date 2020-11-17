package br.com.fiap.saveshare.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.saveshare.models.Reserva;
import br.com.fiap.saveshare.models.Usuario;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Reserva obj WHERE obj.usuario.id = :usuarioId")
	public List<Reserva> findReservasByUsuario(@Param("usuarioId")Integer usuario_id);
	
	@Transactional(readOnly=true)
	Page<Reserva> findByUsuario (Usuario usuario, Pageable pageRequest);

}
