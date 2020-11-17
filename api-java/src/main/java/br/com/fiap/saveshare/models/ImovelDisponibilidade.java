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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ImovelDisponibilidade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDisponibilidade;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date horaInicial;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date horaFinal;
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name="imovel_idImovel")
	private Imovel imovel;
	
	@OneToOne(cascade=CascadeType.ALL, 	mappedBy= "imovelDisponibilidade")
	private Reserva reserva;
	
	public ImovelDisponibilidade() {
	}
	

	public ImovelDisponibilidade(Integer idDisponibilidade, Date horaInicial, Date horaFinal, Imovel imovel, Boolean status) {
		super();
		this.idDisponibilidade = idDisponibilidade;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.imovel = imovel;
		this.status = status;
	}


	public Integer getIdDisponibilidade() {
		return idDisponibilidade;
	}

	public void setIdDisponibilidade(Integer idDisponibilidade) {
		this.idDisponibilidade = idDisponibilidade;
	}

	public Date getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Date horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}


	public Reserva getReserva() {
		return reserva;
	}


	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	
}
