package hibernate;

import hibernate.bean.Pessoas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class RepositorioPessoa {

	

//	EntityManagerFactory emf;
	EntityManager em;

	public RepositorioPessoa(EntityManager em) {
//		emf = Persistence.createEntityManagerFactory("Config");
		this.em = em;
	}

	public int salvar(Pessoas pessoa) {
//		if (!em.getTransaction().isActive()) {
//			em = emf.createEntityManager();
//			em.getTransaction().begin();
//		}
		pessoa = em.merge(pessoa);
//		em.getTransaction().commit();
//		emf.close();
		return pessoa.getPes_id();
	}

	public void remover(Integer id) {
		
		
//		if (!em.getTransaction().isActive()) {
//			em = emf.createEntityManager();
//			em.getTransaction().begin();
//		}
		Pessoas pessoa = em.find(Pessoas.class, id);
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
