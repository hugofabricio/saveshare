package br.com.fiap.saveshare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.saveshare.models.Imovel;
import br.com.fiap.saveshare.models.ImovelFoto;

@Repository
public interface ImovelFotoRepository extends JpaRepository<ImovelFoto, Integer>{
	
	@Transactional(readOnly=true)
	public List<ImovelFoto> findByImovel(Imovel imovel);
	

}
