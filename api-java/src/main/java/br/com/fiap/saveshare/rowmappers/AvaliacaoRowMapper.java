package br.com.fiap.saveshare.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import br.com.fiap.saveshare.models.Avaliacao;
import br.com.fiap.saveshare.models.Reserva;
import br.com.fiap.saveshare.models.Usuario;

public class AvaliacaoRowMapper extends BeanPropertyRowMapper<Avaliacao>{

	public AvaliacaoRowMapper(Class<Avaliacao> clazz) {
		super(clazz);
	}

	@Override
	public Avaliacao mapRow(ResultSet rs, int rowNum) throws SQLException {
		Avaliacao avaliacao = super.mapRow(rs, rowNum);
		
		Reserva reserva = new Reserva();
		reserva.setIdReserva(rs.getInt("id_reserva"));
		avaliacao.setReserva(reserva);
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(rs.getInt("id_usuario"));
		avaliacao.setUsuario(usuario);
		
		return avaliacao;
	}

}
