package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="locations")
public class Location {
	@Id
	@GeneratedValue
	private long id;
	private String nome, citta;
	
	@ManyToOne
	@JoinColumn(name="id_location")
	private Evento evento;
	
	public Location() {}

	public Location(String nome, String citta) {
		super();
		this.nome = nome;
		this.citta = citta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", nome=" + nome + ", citta=" + citta + "]";
	}
	
	
	

}
