package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="USER")
public class User implements Serializable {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String telephone;
	private Date dateNaissance;

	@Column(nullable = false,unique = true)
	private String email;

	private static final long serialVersionUID = 1L;


	@OneToMany(mappedBy ="user")
	private List<Smartphone> phones;
	public User(String nom, String prenom, String telephone, String email, Date dateN) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		dateNaissance = dateN;
	}



	public User() {
		// TODO Auto-generated constructor stub
	}






	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTele() {
		return this.telephone;
	}

	public void setTele(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Date getdateNaissance() {
		return this.dateNaissance;
	}

	public void setdateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}





	public List<Smartphone> getPhones() {
		return phones;
	}





	public void setPhones(List<Smartphone> phones) {
		this.phones = phones;
	}


}


