package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;
import controller.InstanciaBanco;
import controller.Singleton;
import controller.SingletonManipuladorBancoDados;

public class mainSingleton {
	public static void main(String args[]) {
		
		//---------------------------------------------
		// Teste 1
		//---------------------------------------------
		InstanciaBanco.Teste1();
		InstanciaBanco.Teste2();
		//---------------------------------------------
		
		//---------------------------------------------
		// Teste 2
		//---------------------------------------------
		String Sinstance = Singleton.Teste();
		
		System.out.println(Sinstance);
		//---------------------------------------------
		
		//---------------------------------------------
		//Teste 3
		//---------------------------------------------
		try {
			listarPessoas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(SingletonManipuladorBancoDados.getInstance().selectTelefones(telefone));
		//---------------------------------------------
	}
	
	
	private static void listarPessoas() throws SQLException {
		List<Pessoa> listaPessoa = new ArrayList<Pessoa>();
		SingletonManipuladorBancoDados consultaBancoDados = SingletonManipuladorBancoDados.getInstance();
		listaPessoa = consultaBancoDados.selectPessoa(null);
		System.out
				.println("______________________________________________________________________");
		System.out.println("ID----NOME----TELEFONE");
		for (int i = 0; i < listaPessoa.size(); i++)
			System.out.println(listaPessoa.get(i).getId() + " - "
					+ listaPessoa.get(i).getNome() + " - "
					+ listaPessoa.get(i).getTelefone());
		System.out
				.println("______________________________________________________________________");
	}
}
