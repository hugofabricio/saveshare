package br.com.fiap.saveshare.models.dto;

import java.io.Serializable;

import br.com.fiap.saveshare.models.ImovelComodidade;

public class NewImovelComodidadeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private String icone;//O que é isso?
	
	private Integer idImovel;
	
	
	public NewImovelComodidadeDTO() {
	}

	public NewImovelComodidadeDTO(ImovelComodidade imovelComodidade) {
		titulo = imovelComodidade.getTitulo();
		icone = imovelComodidade.getIcone();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	public Integer getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(Integer idImovel) {
		this.idImovel = idImovel;
	}

	
}
