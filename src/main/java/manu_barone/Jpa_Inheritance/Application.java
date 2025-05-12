package manu_barone.Jpa_Inheritance;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dao.GenericDAO;
import entities.Concerto;
import entities.GaraDiAtletica;
import entities.GenereMusicale;
import entities.Location;
import entities.Partecipazione;
import entities.PartitaDiCalcio;
import entities.Persona;
import entities.Stato;
import entities.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class Application {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi");

    public static void main(String[] args) {
    	
    	EntityManager em =  emf.createEntityManager();
    	GenericDAO dao = new GenericDAO(em);
    	
//    	Persona persona1 = new Persona("Mario", "Rossi", "mario.rossi@example.com", LocalDate.of(1980, 5, 15), 'M', null);
//    	Persona persona2 = new Persona("Laura", "Bianchi", "laura.bianchi@example.com", LocalDate.of(1992, 8, 22), 'F', null);
//    	dao.save(persona1);
//    	dao.save(persona2);
//    	
//    	Location location1 = new Location("Stadio Olimpico", "Roma");
//    	Location location2 = new Location("Arena di Verona", "Verona");
//    	dao.save(location1);
//    	dao.save(location2);
//    	
//    	Concerto concerto = new Concerto("Concerto Rock", LocalDate.of(2024, 6, 15), "Concerto di musica rock", TipoEvento.PUBBLICO, 5000, GenereMusicale.ROCK, true);
//    	dao.save(concerto);
//    	
//    	PartitaDiCalcio partita = new PartitaDiCalcio("Finale Coppa Italia", LocalDate.of(2024, 5, 25), 
//    			"Finale tra Squadra A e Squadra B", TipoEvento.PUBBLICO, 60000, "Squadra A", "Squadra B", 3, 2);
//    	partita.setSquadraVincente("Squadra A");
//    	dao.save(partita);
//    	
//    	Set<Persona> atleti = new HashSet<>();
//    	atleti.add(persona1);
//    	atleti.add(persona2);
//    	
//    	GaraDiAtletica gara = new GaraDiAtletica("Gara di 100 metri", LocalDate.of(2024, 7, 10), "Gara atletica 100m", TipoEvento.PUBBLICO, 8, atleti, persona2);
//    	gara.setAtleti(atleti);
//    	dao.save(gara);
//    	
//    	Partecipazione partecipazione1 = new Partecipazione(persona1, concerto, Stato.CONFERMATA);
//    	Partecipazione partecipazione2 = new Partecipazione(persona2, partita, Stato.DA_CONFERMARE);
//    	dao.save(partecipazione1);
//    	dao.save(partecipazione2);
//    	
//    	System.out.println("Dati inseriti nel database.");
    	
    	TypedQuery<Object[]> query = em.createNamedQuery("getPartiteVinteInCasa", Object[].class);
    	List<Object[]> risultati = query.getResultList();
    	
    	for(Object[] risultato: risultati) {
    		String squadraCasa = (String) risultato[0];
    		long conteggio = (long) risultato[1];
    		System.out.println("Squadra: "+ squadraCasa+"\n" + "Conteggio:" + conteggio);
    	}


    }
}
