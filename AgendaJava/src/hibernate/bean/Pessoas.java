package hibernate.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pessoas")
public class Pessoas  implements Serializable{
	
	public Pessoas(){
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -8380151141166700861L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer pes_id;
	
	@Column
	private String pes_nome;
	
	
	public Integer getPes_id() {
		return pes_id;
	}
	public void setPes_id(Integer pes_id) {
		this.pes_id = pes_id;
	}
	public String getPes_nome() {
		return pes_nome;
	}
	public void setPes_nome(String pes_nome) {
		this.pes_nome = pes_nome;
	}

}
