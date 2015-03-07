package hibernate;

import java.util.List;

import hibernate.bean.Pessoas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Pessoa;

public class RepositorioPessoa {

	

//	EntityManagerFactory emf;
	EntityManager em;

	public RepositorioPessoa(EntityManager em) {
//		emf = Persistence.createEntityManagerFactory("Config");
		this.em = em;
	}

	public void salvar(Pessoas pessoa) {
//		if (!em.getTransaction().isActive()) {
//			em = emf.createEntityManager();
//			em.getTransaction().begin();
//		}
		em.merge(pessoa);
		em.getTransaction().commit();
//		emf.close();
	}

	public void remover(Pessoas pessoa) {
		
		
//		if (!em.getTransaction().isActive()) {
//			em = emf.createEntityManager();
//			em.getTransaction().begin();
//		}
		pessoa = em.find(Pessoas.class, pessoa.getPes_id());
		em.remove(pessoa);
//		em.getTransaction().commit();
//		emf.close();
	}

	public void listar() {
//		if (!em.getTransaction().isActive()) {
//			em = emf.createEntityManager();
//			em.getTransaction().begin();
//		}
		Query consulta = em.createQuery("select p from Pessoas p");
		@SuppressWarnings("unchecked")
		List<Pessoas> lista = consulta.getResultList();

		for (Pessoas pessoa : lista) {
			System.out.println(pessoa.getPes_id());
			System.out.println(pessoa.getPes_nome());

		}

//		em.getTransaction().commit();
//		emf.close();
	}
}
