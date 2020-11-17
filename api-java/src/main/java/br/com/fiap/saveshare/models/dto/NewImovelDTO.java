package br.com.fiap.saveshare.models.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.fiap.saveshare.models.Imovel;

public class NewImovelDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=3, max=120, message="O tamanho deve ser entre 3 e 120 caracteres")
	private String titulo;
	@Column(columnDefinition = "TEXT")
	private String descricao;
//	private BigDecimal valorHora;
	private BigDecimal valorDia;
//	private BigDecimal valorSemana;
	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
//	private String latitude;
//	private String longitude;
	
	private Integer idUsuario;

	private Integer idTipoImovel;
	
	public NewImovelDTO() {
	}
	
	public NewImovelDTO(Imovel imovel) {
		titulo = imovel.getTitulo();
		descricao = imovel.getDescricao();
//		valorHora = imovel.getValorHora();
		valorDia = imovel.getValorDia();
//		valorSemana = imovel.getValorSemana();
		cep = imovel.getCep();
		logradouro = imovel.getLogradouro();
		numero = imovel.getNumero();
		complemento = imovel.getComplemento();
		bairro = imovel.getBairro();
		cidade = imovel.getCidade();
		uf = imovel.getUf();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

//	public BigDecimal getValorHora() {
//		return valorHora;
//	}
//
//	public void setValorHora(BigDecimal valorHora) {
//		this.valorHora = valorHora;
//	}

	public BigDecimal getValorDia() {
		return valorDia;
	}

	public void setValorDia(BigDecimal valorDia) {
		this.valorDia = valorDia;
	}

//	public BigDecimal getValorSemana() {
//		return valorSemana;
//	}
//
//	public void setValorSemana(BigDecimal valorSemana) {
//		this.valorSemana = valorSemana;
//	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

//	public String getLatitude() {
//		return latitude;
//	}
//
//	public void setLatitude(String latitude) {
//		this.latitude = latitude;
//	}
//
//	public String getLongitude() {
//		return longitude;
//	}
//
//	public void setLongitude(String longitude) {
//		this.longitude = longitude;
//	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdTipoImovel() {
		return idTipoImovel;
	}

	public void setIdTipoImovel(Integer idTipoImovel) {
		this.idTipoImovel = idTipoImovel;
	}

	@Override
	public String toString() {
		return "NewImovelDTO [" + (titulo != null ? "titulo=" + titulo + ", " : "")
				+ (descricao != null ? "descricao=" + descricao + ", " : "")
//				+ (valorHora != null ? "valorHora=" + valorHora + ", " : "")
				+ (valorDia != null ? "valorDia=" + valorDia + ", " : "")
//				+ (valorSemana != null ? "valorSemana=" + valorSemana + ", " : "")
				+ (cep != null ? "cep=" + cep + ", " : "")
				+ (logradouro != null ? "logradouro=" + logradouro + ", " : "")
				+ (numero != null ? "numero=" + numero + ", " : "")
				+ (complemento != null ? "complemento=" + complemento + ", " : "")
				+ (bairro != null ? "bairro=" + bairro + ", " : "") + (cidade != null ? "cidade=" + cidade + ", " : "")
				+ (uf != null ? "uf=" + uf + ", " : "") + (idUsuario != null ? "idUsuario=" + idUsuario + ", " : "")
				+ (idTipoImovel != null ? "idTipoImovel=" + idTipoImovel : "") + "]";
	}
	
	

}
