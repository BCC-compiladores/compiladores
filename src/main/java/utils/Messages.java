package utils;

/**
 * Enum to store all messages displayed by the application
 */

public enum Messages {

    EMPTY_PROGRAM("Nenhum programa para compilar"),
	MEMBERS("Integrantes: \n Jonathan Luiz de Lara \n Matheus Heiden \n Pedro Henrique Pereira Alba"),
	OPERACAO_ARITMETICA_UNARIA("tipo incompatível em operação aritmética unária"),
	OPERACAO_ARITMETICA_BINARIA("tipos incompatíveis em operação aritmética binária"),
	OPERACAO_RELACIONAL("tipos incompatíveis em operação relacional"),
	OPERACAO_LOGICA_UNARIA("tipo incompatível em operação lógica unária"),
	OPERACAO_LOGICA_BINARIA("tipos incompatíveis em operação lógica binária"),
	IDENTIFICADOR_NAO_DECLARADO("identificador não declarado"),
	IDENTIFICADOR_JA_DECLARADO("identificador já declarado"),
	TIPO_INCOMPATIVEL_ATRIBUICAO("tipo incompatível em comando de atribuição");
	
	private final String msg;
	
	Messages(String msg){
		this.msg = msg;
	}
	
	public String get() {
		return msg;
	}
	
	@Override
	public String toString() {
		return msg;
	}
}
