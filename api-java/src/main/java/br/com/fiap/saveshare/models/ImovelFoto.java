package br.com.fiap.saveshare.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class ImovelFoto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFotoImovel;
	@Lob
	private byte[] foto;
	private String legenda;
	
	@ManyToOne
	@JoinColumn(name="imovel_idImovel")
	private Imovel imovel;
	
	@ManyToOne
	@JoinColumn(name = "usuario_idUsuario")
	private Usuario usuario;
	
	public ImovelFoto() {
	}

	public ImovelFoto(Integer idFotoImovel, byte[] foto, String legenda, Imovel imovel, Usuario usuario) {
		this.idFotoImovel = idFotoImovel;
		this.foto = foto;
		this.legenda = legenda;
		this.imovel = imovel;
		this.usuario = usuario;
	}

	public Integer getIdFotoImovel() {
		return idFotoImovel;
	}

	public void setIdFotoImovel(Integer idFotoImovel) {
		this.idFotoImovel = idFotoImovel;
	}

	public String getLegenda() {
		return legenda;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	
}
