package hibernate;

import hibernate.bean.Pessoas;

public class MainHibernate {

	public static void main(String[] args) {
		
		RepositorioPessoa repositorio = new RepositorioPessoa();
		
		Pessoas pessoas = new Pessoas();
		pessoas.setPes_id(5);
		pessoas.setPes_nome("cadu");
		repositorio.salvar(pessoas);
		repositorio.listar();
		repositorio.remover(pessoas);
		System.out.println();
		System.out.println("Depois da remoção");
		repositorio.listar();
		

	}

}
