package utils;

/**
 * Enum to store all messages displayed by the application
 */

public enum Messages {

	NOT_YET_IMPLEMENTED("Compilação de programas ainda não implementada"),
	MEMBERS("Integrantes: \n Jonathan Luiz de Lara \n Matheus Heiden \n Pedro Henrique Pereira Alba");
	
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
