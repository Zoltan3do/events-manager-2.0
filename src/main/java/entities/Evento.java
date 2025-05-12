package entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="events")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Evento {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="titolo", nullable = false)
	private String titolo;
	
	@Column(name="data_evento", nullable = false)
	private LocalDate dataEvento;
	
	@Column(name="descrizione", nullable = false)
	private String descrizione;
	
	@Column(name = "tipo-evento")
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;
	
	@Column(name = "max_partecipanti")
	private int maxPartecipanti;
	
	@Column(name="id_location")
	private UUID id_location;
	
	@OneToMany
	private List<Location>locazioni;
	
	
	
	public Evento() {}

	public Evento( String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int maxPartecipanti) {
		super();
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.maxPartecipanti = maxPartecipanti;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public int getMaxPartecipanti() {
		return maxPartecipanti;
	}

	public void setMaxPartecipanti(int maxPartecipanti) {
		this.maxPartecipanti = maxPartecipanti;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titolo=" + titolo + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
				+ ", tipoEvento=" + tipoEvento + ", maxPartecipanti=" + maxPartecipanti + "]";
	}
	
	
}
