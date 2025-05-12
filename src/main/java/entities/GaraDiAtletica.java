package entities;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@DiscriminatorValue("Atletica")

public class GaraDiAtletica extends Evento{ 


	@ManyToMany
	@JoinTable(
			name="gara_atleti",
			joinColumns = @JoinColumn(name = "gara_id"),
			inverseJoinColumns = @JoinColumn(name="persona_id")
			)
	private Set<Persona> atleti;
	
	@ManyToOne
	@JoinColumn(name="vincitore_id")
	private Persona vincitore;
	
	public GaraDiAtletica() {}
	
	public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int maxPartecipanti,Set<Persona>atleti,Persona vincitore) {
		super(titolo, dataEvento, descrizione, tipoEvento, maxPartecipanti);
		this.atleti = atleti;
		this.vincitore = vincitore;
	}
	
    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

	public Persona getVincitore() {
		return vincitore;
	}

	public void setVincitore(Persona vincitore) {
		this.vincitore = vincitore;
	}

	@Override
	public String toString() {
		return "GaraDiAtletica [atleti=" + atleti + ", vincitore=" + vincitore + "]";
	}

    
   

}
