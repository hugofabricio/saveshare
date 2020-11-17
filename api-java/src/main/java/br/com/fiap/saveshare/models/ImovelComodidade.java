package br.com.fiap.saveshare.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ImovelComodidade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idComodidade;
	private String titulo;
	private String icone;//O que é isso?
	
	@ManyToOne
	@JoinColumn(name="imovel_idImovel")
	private Imovel imovel;
	
	public ImovelComodidade() {
	}
	
	public ImovelComodidade(Integer idComodidade, String titulo, String icone, Imovel imovel) {
		super();
		this.idComodidade = idComodidade;
		this.titulo = titulo;
		this.icone = icone;
		this.imovel = imovel;
	}



	public Integer getIdComodidade() {
		return idComodidade;
	}

	public void setIdComodidade(Integer idComodidade) {
		this.idComodidade = idComodidade;
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

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	

}
