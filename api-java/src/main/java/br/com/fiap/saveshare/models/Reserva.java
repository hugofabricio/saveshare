package br.com.fiap.saveshare.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReserva;
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name="imovel_idImovel")
	private Imovel imovel;
	
	@ManyToOne
	@JoinColumn(name="usuario_id_usuario")
	private Usuario usuario;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="imovel_disponibilidade_idDisponibilidade")
	private ImovelDisponibilidade imovelDisponibilidade;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="avaliacao_idAvaliacao")
	private Avaliacao avaliacao;
	
	public Reserva() {
	}

	public Reserva(Integer idReserva, Imovel imovel, Usuario usuario, Boolean status, ImovelDisponibilidade disponibilidade) {
		this.idReserva = idReserva;
		this.imovel = imovel;
		this.usuario = usuario;
		this.status = status;
		this.imovelDisponibilidade = disponibilidade;
	}


	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public ImovelDisponibilidade getImovelDisponibilidade() {
		return imovelDisponibilidade;
	}

	public void setImovelDisponibilidade(ImovelDisponibilidade imovelDisponibilidade) {
		this.imovelDisponibilidade = imovelDisponibilidade;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	

}
