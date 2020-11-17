package br.com.fiap.saveshare.models.enums;

public enum TipoUsuarioEnum {
	LOCADOR(1,"Locador"),
	LOCATARIO(2,"Locatario");

	private String descricao;
	private Integer value;
	
	private TipoUsuarioEnum(String descricao) {
		this.descricao = descricao;
	}

	TipoUsuarioEnum(Integer value, String descricao) {
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
