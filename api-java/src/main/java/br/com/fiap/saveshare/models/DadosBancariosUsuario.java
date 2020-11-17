package br.com.fiap.saveshare.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DadosBancariosUsuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDadosBancarios;
	private String banco;
	private String agencia;
	private String conta;
	private String tipoConta; 
	private Integer idUsuario;
	
	public DadosBancariosUsuario() {
	}
	
	public DadosBancariosUsuario(Integer idDadosBancarios, String banco, String agencia, String conta,
			String tipoConta) {
		super();
		this.idDadosBancarios = idDadosBancarios;
		this.banco = banco;
		this.agencia = agencia;
		this.conta = conta;
		this.tipoConta = tipoConta;
	}

	public Integer getIdDadosBancarios() {
		return idDadosBancarios;
	}

	public void setIdDadosBancarios(Integer idDadosBancarios) {
		this.idDadosBancarios = idDadosBancarios;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "DadosBancariosUsuario ["
				+ (idDadosBancarios != null ? "idDadosBancarios=" + idDadosBancarios + ", " : "")
				+ (banco != null ? "banco=" + banco + ", " : "") + (agencia != null ? "agencia=" + agencia + ", " : "")
				+ (conta != null ? "conta=" + conta + ", " : "") + (tipoConta != null ? "tipoConta=" + tipoConta : "")
				+ "]";
	}

	
}
