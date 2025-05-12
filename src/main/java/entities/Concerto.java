package entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Concerto extends Evento{
	
	private GenereMusicale gm;
	private boolean isStreaming;
	
	
	public Concerto() {}

	public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int maxPartecipanti, GenereMusicale gm, boolean isStreaming) {
		super(titolo, dataEvento, descrizione, tipoEvento, maxPartecipanti);
		this.gm = gm;
		this.isStreaming = isStreaming;
	}

	public GenereMusicale getGm() {
		return gm;
	}

	public void setGm(GenereMusicale gm) {
		this.gm = gm;
	}

	public boolean isStreaming() {
		return isStreaming;
	}

	public void setStreaming(boolean isStreaming) {
		this.isStreaming = isStreaming;
	}

	@Override
	public String toString() {
		return "Concerto [gm=" + gm + ", isStreaming=" + isStreaming + "]";
	}
	
	

	
	

}
