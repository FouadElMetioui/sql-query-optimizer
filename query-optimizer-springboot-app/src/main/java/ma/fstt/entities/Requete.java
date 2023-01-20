package ma.fstt.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="requetes")

public class Requete {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String requete;
	private String result ; 
	
	public String getRequete() {
		return requete;
	}

	public void setRequete(String requete) {
		this.requete = requete;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Requete(int id, String requete, String result) {
		super();
		this.id = id;
		this.requete = requete;
		this.result = result;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", requete=" + requete + ", result=" + result + "]";
	}

	public Requete() {
		super();
	}

	public Requete(String requete, String result) {
		super();
		this.requete = requete;
		this.result = result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	} 
	
	
}
