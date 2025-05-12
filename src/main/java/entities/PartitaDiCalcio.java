package entities;

import java.time.LocalDate;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;

@Entity
@DiscriminatorValue("Calcio")
@NamedQuery(name = "getPartiteVinteInCasa",
			query = "SELECT squadraCasa, count(p.id) as conteggio FROM PartitaDiCalcio p WHERE p.squadraCasa = p.squadraVincente GROUP BY p.squadraCasa")
@NamedQuery(name = "getPartiteVinteInTrasferta",
			query = "SELECT squadraOspite, count(p.id) as conteggio FROM PartitaDiCalcio p WHERE p.squadraOspite = p.squadraVincente GROUP BY p.squadraOspite")

public class PartitaDiCalcio extends Evento {
	private String squadraCasa, squadraOspite, squadraVincente = null;
	private int golsSC, golsSO;
	
	public PartitaDiCalcio() {}

	public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int maxPartecipanti, String squadraCasa, String squadraOspite, int golsSC, int golsSO) {
		super(titolo, dataEvento, descrizione, tipoEvento, maxPartecipanti);
		this.squadraCasa = squadraCasa;
		this.squadraOspite = squadraOspite;
		this.golsSC = golsSC;
		this.golsSO = golsSO;
	}

	public String getSquadraCasa() {
		return squadraCasa;
	}
	public void setSquadraCasa(String squadraCasa) {
		this.squadraCasa = squadraCasa;
	}
	public String getSquadraOspite() {
		return squadraOspite;
	}
	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}
	public String getSquadraVincente() {
		return squadraVincente;
	}
	public void setSquadraVincente(String squadraVincente) {
		this.squadraVincente = squadraVincente;
	}
	public int getGolsSC() {
		return golsSC;
	}
	public void setGolsSC(int golsSC) {
		this.golsSC = golsSC;
	}
	public int getGolsSO() {
		return golsSO;
	}
	public void setGolsSO(int golsSO) {
		this.golsSO = golsSO;
	}
	@Override
	public String toString() {
		return "PartitaDiCalcio [squadraCasa=" + squadraCasa + ", squadraOspite=" + squadraOspite + ", squadraVincente="
				+ squadraVincente + ", golsSC=" + golsSC + ", golsSO=" + golsSO + "]";
	}
	

}
