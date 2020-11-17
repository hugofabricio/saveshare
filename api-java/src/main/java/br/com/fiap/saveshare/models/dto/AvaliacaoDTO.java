package br.com.fiap.saveshare.models.dto;

import java.io.Serializable;

import br.com.fiap.saveshare.models.Avaliacao;

public class AvaliacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String comentario;
	private Double nota;
	private Integer idUsuario;
	private Integer idReserva;
	
	
	public AvaliacaoDTO() {
	}

	public AvaliacaoDTO(Avaliacao avaliacao) {
		comentario = avaliacao.getComentario();
		nota = avaliacao.getNota();
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	
}
