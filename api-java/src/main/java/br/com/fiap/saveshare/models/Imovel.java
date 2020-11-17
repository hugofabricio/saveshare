package br.com.fiap.saveshare.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Imovel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idImovel;
	private String titulo;
	@Column(columnDefinition = "TEXT")
	private String descricao;
//	private BigDecimal valorHora;
	private BigDecimal valorDia;
//	private BigDecimal valorSemana;
	private Double nota;
	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String latitude;
	private String longitude;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date criacao;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date atualizacao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "imovel")
	private List<ImovelFoto> fotos = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "imovel")
	private List<ImovelComodidade> comodidades = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "imovel")
	private List<ImovelDisponibilidade> disponibilidades = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="usuario_id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="tipo_imovel_id")
	private TipoImovel tipoImovel;
	
	
	public Imovel() {
		
	}
	
	public Imovel(Integer idImovel, String titulo, String descricao, BigDecimal valorDia,
		 Double nota, String cep, String logradouro, String numero, String complemento,
			String bairro, String cidade, String uf, String latitude, String longitude, Date criacao, Date atualizacao) {
		this.idImovel = idImovel;
		this.titulo = titulo;
		this.descricao = descricao;
//		this.valorHora = valorHora;
		this.valorDia = valorDia;
//		this.valorSemana = valorSemana;
		this.nota = nota;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.latitude = latitude;
		this.longitude = longitude;
		this.criacao = criacao;
		this.atualizacao = atualizacao;
	}

	public Integer getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(Integer idImovel) {
		this.idImovel = idImovel;
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

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Date getCriacao() {
		return criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	public Date getAtualizacao() {
		return atualizacao;
	}

	public void setAtualizacao(Date atualizacao) {
		this.atualizacao = atualizacao;
	}

	public List<ImovelFoto> getFotos() {
		return fotos;
	}

	public void setFotos(List<ImovelFoto> fotos) {
		this.fotos = fotos;
	}

	public List<ImovelComodidade> getComodidades() {
		return comodidades;
	}

	public void setComodidades(List<ImovelComodidade> comodidades) {
		this.comodidades = comodidades;
	}

	public List<ImovelDisponibilidade> getDisponibilidades() {
		return disponibilidades;
	}

	public void setDisponibilidades(List<ImovelDisponibilidade> disponibilidades) {
		this.disponibilidades = disponibilidades;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoImovel getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(TipoImovel tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	@Override
	public String toString() {
		return "Imovel [" + (idImovel != null ? "idImovel=" + idImovel + ", " : "")
				+ (titulo != null ? "titulo=" + titulo + ", " : "")
				+ (descricao != null ? "descricao=" + descricao + ", " : "")
//				+ (valorHora != null ? "valorHora=" + valorHora + ", " : "")
				+ (valorDia != null ? "valorDia=" + valorDia + ", " : "")
//				+ (valorSemana != null ? "valorSemana=" + valorSemana + ", " : "")
				+ (nota != null ? "nota=" + nota + ", " : "") + (cep != null ? "cep=" + cep + ", " : "")
				+ (logradouro != null ? "logradouro=" + logradouro + ", " : "")
				+ (numero != null ? "numero=" + numero + ", " : "")
				+ (complemento != null ? "complemento=" + complemento + ", " : "")
				+ (bairro != null ? "bairro=" + bairro + ", " : "") + (cidade != null ? "cidade=" + cidade + ", " : "")
				+ (uf != null ? "uf=" + uf + ", " : "") + (latitude != null ? "latitude=" + latitude + ", " : "")
				+ (longitude != null ? "longitude=" + longitude + ", " : "")
				+ (criacao != null ? "criacao=" + criacao + ", " : "")
				+ (atualizacao != null ? "atualizacao=" + atualizacao + ", " : "")
				+ (fotos != null ? "fotos=" + fotos + ", " : "")
				+ (comodidades != null ? "comodidades=" + comodidades + ", " : "")
				+ (disponibilidades != null ? "disponibilidades=" + disponibilidades + ", " : "")
				+ (usuario != null ? "usuario=" + usuario + ", " : "")
				+ (tipoImovel != null ? "tipoImovel=" + tipoImovel : "") + "]";
	}
	
	
	
}
