package hibernate;

import hibernate.bean.Pessoas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class RepositorioPessoa {

	EntityManager em;

	public RepositorioPessoa(EntityManager em) {
		this.em = em;
	}

	public int salvar(Pessoas pessoa) {
		pessoa = em.merge(pessoa);
		return pessoa.getPes_id();
	}

	public void remover(Integer id) {
		Pessoas pessoa = em.find(Pessoas.class, id);
		em.remove(pessoa);
	}

	public void listar() {
		Query consulta = em.createQuery("select p from Pessoas p");
		
		@SuppressWarnings("unchecked")
		List<Pessoas> lista = consulta.getResultList();

		for (Pessoas pessoa : lista) {
			System.out.println(pessoa.getPes_id());
			System.out.println(pessoa.getPes_nome());

		}
	}
}
