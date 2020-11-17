package br.com.fiap.saveshare.models.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.fiap.saveshare.models.ImovelDisponibilidade;

public class NewImovelDisponibilidadeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date horaInicial;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date horaFinal;
	
	private Integer idImovel;
	
	
	public NewImovelDisponibilidadeDTO() {
	}
	
	public NewImovelDisponibilidadeDTO(ImovelDisponibilidade imovelDisponibilidade) {
		horaInicial = imovelDisponibilidade.getHoraInicial();
		horaFinal = imovelDisponibilidade.getHoraFinal();
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

	public Integer getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(Integer idImovel) {
		this.idImovel = idImovel;
	}

	
}
