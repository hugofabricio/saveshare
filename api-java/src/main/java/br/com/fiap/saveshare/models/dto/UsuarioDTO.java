package br.com.fiap.saveshare.models.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.fiap.saveshare.models.DadosBancariosUsuario;
import br.com.fiap.saveshare.models.Usuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idUsuario;
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=3, max=120, message="O tamanho deve ser entre 3 e 120 caracteres")
	private String nome;
	@NotEmpty(message="Preenchimento obrigatório")
	private String sobrenome;
	@NotEmpty(message="Preenchimento obrigatório")
	private String telefone;
	private Boolean status;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
//	private Integer tipo;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String banco;
	@NotEmpty(message="Preenchimento obrigatório")
	private String agencia;
	@NotEmpty(message="Preenchimento obrigatório")
	private String conta;
	@NotEmpty(message="Preenchimento obrigatório")
	private String tipoConta; 
	
	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario usuario, DadosBancariosUsuario dadosBancarios) {
		setIdUsuario(usuario.getIdUsuario());
		nome = usuario.getNome();
		sobrenome = usuario.getSobrenome();
		telefone = usuario.getTelefone();
		status = usuario.getStatus();
		banco = dadosBancarios.getBanco();
		agencia = dadosBancarios.getAgencia();
		conta = dadosBancarios.getConta();
		tipoConta = dadosBancarios.getTipoConta();
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

//	public Integer getTipo() {
//		return tipo;
//	}
//
//	public void setTipo(Integer tipo) {
//		this.tipo = tipo;
//	}

	
}
