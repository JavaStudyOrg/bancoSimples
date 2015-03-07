package hibernate;

import hibernate.bean.Pessoas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainHibernate {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Config");
	    EntityManager em = emf.createEntityManager();
	    
	    em.getTransaction().begin();
		RepositorioPessoa repositorio = new RepositorioPessoa(em);
		
		Pessoas pessoas = new Pessoas();
		pessoas.setPes_nome("cadu");
		int id = repositorio.salvar(pessoas);
		repositorio.listar();
		repositorio.remover(id);
		System.out.println();
		System.out.println("Depois da remoção");
		em.getTransaction().commit();
		repositorio.listar();
		em.close();
		emf.close();

	}

}
