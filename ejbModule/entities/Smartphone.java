package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: smartphone
 *
 */
@Entity
@Table(name="SMARTPHONE")
public class Smartphone implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String marque;
	private String name;
	private String ref;



	@ManyToOne
	@JoinColumn(name ="user_id")
	private User user;
	@OneToMany(targetEntity = Position.class, mappedBy = "smartPhone", fetch = FetchType.EAGER)
	private List<Position> positions;
	private static final long serialVersionUID = -558553967080513790L;
	public Smartphone(String marque,String name,String ref) {
		super();
		this.id=id;
		this.marque = marque;
		this.name=name;
		this .ref=ref;

	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Smartphone() {
		super();
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}


	}


