package br.com.fiap.saveshare.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.fiap.saveshare.models.Avaliacao;
import br.com.fiap.saveshare.rowmappers.AvaliacaoRowMapper;

@Repository
public class AvaliacaoDao {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	JdbcTemplate jdbc;

	public List<Avaliacao> listaAvaliacoesImovel(Integer idImovel) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT A.ID_AVALIACAO, A.COMENTARIO, A.NOTA, A.CRIACAO, A.TIPO_USUARIO, R.ID_RESERVA AS ID_RESERVA, U.ID_USUARIO AS ID_USUARIO ")
		.append(" FROM AVALIACAO as A ")
		.append(" LEFT JOIN RESERVA AS R ON R.AVALIACAO_ID_AVALIACAO = A.ID_AVALIACAO ")
		.append(" LEFT JOIN USUARIO AS U ON U.ID_USUARIO = A.USUARIO_ID_USUARIO ")
		.append(" WHERE A.TIPO_USUARIO = 'Locatario' ");

		MapSqlParameterSource params = new MapSqlParameterSource();
			sql.append(" AND R.IMOVEL_ID_IMOVEL = :idImovel"); 
			params.addValue("idImovel", idImovel);

		List<Avaliacao> query = jdbcTemplate.query(sql.toString(), params, new AvaliacaoRowMapper(Avaliacao.class));

		return query;
	}
	
	public List<Avaliacao> listaAvaliacoesUsuario(Integer idUsuario) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT A.ID_AVALIACAO, A.COMENTARIO, A.NOTA, A.CRIACAO, A.TIPO_USUARIO, R.ID_RESERVA AS ID_RESERVA, U.ID_USUARIO AS ID_USUARIO ")
		.append(" FROM AVALIACAO as A ")
		.append(" LEFT JOIN RESERVA AS R ON R.AVALIACAO_ID_AVALIACAO = A.ID_AVALIACAO ")
		.append(" LEFT JOIN USUARIO AS U ON U.ID_USUARIO = A.USUARIO_ID_USUARIO ")
		.append(" WHERE A.TIPO_USUARIO = 'Locador' ");

		MapSqlParameterSource params = new MapSqlParameterSource();
		sql.append(" AND R.USUARIO_ID_USUARIO = :idUsuario"); 
		params.addValue("idUsuario", idUsuario);

	List<Avaliacao> query = jdbcTemplate.query(sql.toString(), params, new AvaliacaoRowMapper(Avaliacao.class));

	return query;
	}
}
