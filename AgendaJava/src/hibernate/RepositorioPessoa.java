package hibernate;

import java.util.List;

import hibernate.bean.Pessoas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RepositorioPessoa {

	public static void main(String args[]) throws Exception {

	}

	EntityManagerFactory emf;
	EntityManager em;

	public RepositorioPessoa() {
		emf = Persistence.createEntityManagerFactory("Config");
		em = emf.createEntityManager();
	}

	public void salvar(Pessoas pessoa) {
		em.getTransaction().begin();
		em.merge(pessoa);
		em.getTransaction().commit();
		// emf.close();
	}

	public void remover(Pessoas pessoa) {
		em.getTransaction().begin();
		em.remove(pessoa);
		em.getTransaction().commit();
		emf.close();
	}

	public void listar() {
		em.getTransaction().begin();
		Query consulta = em.createQuery("select p from Pessoas p");
		@SuppressWarnings("unchecked")
		List<Pessoas> lista = consulta.getResultList();

		for (Pessoas pessoa : lista) {
			System.out.println(pessoa.getPes_id());
			System.out.println(pessoa.getPes_nome());

		}

		em.getTransaction().commit();
		emf.close();
	}
}
