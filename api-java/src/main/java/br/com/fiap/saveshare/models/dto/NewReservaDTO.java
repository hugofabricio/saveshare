package br.com.fiap.saveshare.models.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class NewReservaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private Integer idDisponibilidade;
	private Integer idImovel;
	private Integer idUsuario;
	
	public NewReservaDTO() {
	}

	public Integer getIdDisponibilidade() {
		return idDisponibilidade;
	}

	public void setIdDisponibilidade(Integer idDisponibilidade) {
		this.idDisponibilidade = idDisponibilidade;
	}

	public Integer getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(Integer idImovel) {
		this.idImovel = idImovel;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	
}
