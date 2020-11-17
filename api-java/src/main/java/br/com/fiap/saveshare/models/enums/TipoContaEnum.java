package br.com.fiap.saveshare.models.enums;

public enum TipoContaEnum {
	POUPANCA(1,"Poupança"),
	CORRENTE(2,"Corrente");

	private String descricao;
	private Integer value;
	
	private TipoContaEnum(String descricao) {
		this.descricao = descricao;
	}

	TipoContaEnum(Integer value, String descricao) {
		this.value = value;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getValue() {
		return value;
	}
	
	
	
}
