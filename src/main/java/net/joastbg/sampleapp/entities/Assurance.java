package net.joastbg.sampleapp.entities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public abstract class Assurance {

	private int numero;

	private Date dateSouscription;

	private Date dateAnniversaire;

	private Date datePrelevement;
	
	private Client client;

	private boolean resiliation;
	
	private List<Echeances> echeances;

	//private List<Sinistre> sinistres;
	
	public void activationResiliation(){
		Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		if(date.equals(dateAnniversaire) && resiliation){
			dateAnniversaire = null;
			datePrelevement = null;
		}
	}
	
	public boolean getResiliation(){
		return resiliation;
	}
	
	public void setResiliation(boolean b){
		resiliation = b;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDateSouscription() {
		return dateSouscription;
	}

	public void setDateSouscription(Date dateSouscription) {
		this.dateSouscription = dateSouscription;
	}

	public Date getDateAnniversaire() {
		return dateAnniversaire;
	}

	public void setDateAnniversaire(Date dateAnniversaire) {
		this.dateAnniversaire = dateAnniversaire;
	}

	public Date getDatePrelevement() {
		return datePrelevement;
	}

	public void setDatePrelevement(Date datePrelevement) {
		this.datePrelevement = datePrelevement;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Echeances> getEcheances() {
		return echeances;
	}

	public void setEcheances(List<Echeances> echeances) {
		this.echeances = echeances;
	}
}
