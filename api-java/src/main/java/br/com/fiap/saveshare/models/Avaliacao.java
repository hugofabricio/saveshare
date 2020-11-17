package br.com.fiap.saveshare.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Avaliacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAvaliacao;
	
	@ManyToOne
	@JoinColumn(name="usuario_idUsuario")
	private Usuario usuario;
	
	@OneToOne(cascade=CascadeType.ALL, 	mappedBy= "avaliacao")
	private Reserva reserva;

	private String comentario;
	private Double nota;
	private Date criacao;
	private String tipoUsuario;
	
	public Avaliacao() {
	}
	
	public Avaliacao(Integer idAvaliacao, Usuario usuario, Reserva reserva, String comentario, Double nota,
			Date criacao, String tipoUsuario) {
		this.idAvaliacao = idAvaliacao;
		this.usuario = usuario;
		this.reserva = reserva;
		this.comentario = comentario;
		this.nota = nota;
		this.criacao = criacao;
		this.tipoUsuario = tipoUsuario;
	}

	public Integer getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Integer idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
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

	public Date getCriacao() {
		return criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
}
