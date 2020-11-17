package br.com.fiap.saveshare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.saveshare.models.ImovelDisponibilidade;

@Repository
public interface ImovelDisponibilidadeRepository extends JpaRepository<ImovelDisponibilidade, Integer>{
	

}
