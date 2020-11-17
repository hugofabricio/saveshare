package br.com.fiap.saveshare.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fiap.saveshare.models.enums.Perfil;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUsuario;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private String cpf;
	private String telefone;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataUltimoAcesso;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataCadastro;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataUltimaAtualizacao;
	private Boolean status;
	
	@JsonIgnore
	@OneToMany(mappedBy="usuario")
	private List<Imovel> imoveis = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="usuario")
	private List<Avaliacao> avaliacoes = new ArrayList<>();
	
	@OneToMany(mappedBy="usuario")
	private List<ImovelFoto> fotos = new ArrayList<>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	
	public Usuario() {
		addPerfil(Perfil.CLIENTE);
	}

	public Usuario(Integer idUsuario, String nome, String sobrenome, String email, String senha, String cpf,
			String telefone, Date dataNascimento, Boolean status, Date dataCadastro
			) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.status = status;
		this.dataCadastro = dataCadastro;
		addPerfil(Perfil.CLIENTE);
	}
	
	public Set<Perfil> getPerfis () {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	public void addPerfil (Perfil perfil) {
		perfis.add(perfil.getCod());
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonIgnore
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}

	public void setDataUltimoAcesso(Date dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	

	@Override
	public String toString() {
		return "Usuario [" + (idUsuario != null ? "idUsuario=" + idUsuario + ", " : "")
				+ (nome != null ? "nome=" + nome + ", " : "")
				+ (sobrenome != null ? "sobrenome=" + sobrenome + ", " : "")
				+ (email != null ? "email=" + email + ", " : "") + (senha != null ? "senha=" + senha + ", " : "")
				+ (cpf != null ? "cpf=" + cpf + ", " : "") + (telefone != null ? "telefone=" + telefone + ", " : "")
				+ (dataNascimento != null ? "dataNascimento=" + dataNascimento + ", " : "")
				+ (dataUltimoAcesso != null ? "dataUltimoAcesso=" + dataUltimoAcesso + ", " : "")
				+ (dataCadastro != null ? "dataCadastro=" + dataCadastro + ", " : "")
				+ (dataUltimaAtualizacao != null ? "dataUltimaAtualizacao=" + dataUltimaAtualizacao + ", " : "")
				+ (status != null ? "status=" + status + ", " : "")
				+ "]"
				;
	}

}
