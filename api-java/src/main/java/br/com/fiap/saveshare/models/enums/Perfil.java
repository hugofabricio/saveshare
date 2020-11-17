package br.com.fiap.saveshare.models.enums;

public enum Perfil {
	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");

	private int cod;
	private String descricao;
	
	// construtor de Enum é private
	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	//Enum não tem set, só get
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	//Código pra receber o código do Enum e já instanciar o enum completo
	//static representa que você pode usar este método mesmo sem ter um objeto instanciado
	public static Perfil toEnum(Integer cod) {
		
		if(cod==null) {
			return null;
		}
		// x representa o objeto que está sendo percorrido
		for(Perfil x : Perfil.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod); //Caso não seja encontrado lança essa exceção
	}
}
