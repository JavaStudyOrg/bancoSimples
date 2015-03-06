package controller;


//Exemplo Singleton - Para entender como funciona
public final class InstanciaBanco {

	//atributos que n�o ser�o vistos fora da classe
	private static final InstanciaBanco INSTANCE = new InstanciaBanco();
	
	//atributos que podem ser vistos fora deste escopo
	public static final String Singleton = "Teste";
		
	//m�todo construtor
	public InstanciaBanco(){
		
	}
	
	//retorna a inst�ncia da classe
	public static InstanciaBanco getInstance(){
		return INSTANCE;
	}
	
	//----------------------------------------------
	//m�todos que podem ser acessados fora do escopo
	//----------------------------------------------
	public static void Teste1(){
		System.out.println("teste1");
	}
	
	public static void Teste2(){
		System.out.println("teste2");
	}
	//----------------------------------------------
}
