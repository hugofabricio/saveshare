package br.com.fiap.saveshare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.saveshare.models.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Imovel obj WHERE obj.usuario.id = :usuarioId")
	public List<Imovel> findImoveisByUsuario(@Param("usuarioId")Integer usuario_id);

}
