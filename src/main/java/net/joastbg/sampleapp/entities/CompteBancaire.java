package net.joastbg.sampleapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COMPTE_BANCAIRE")
public class CompteBancaire {
	@Column(name = "iban")
	private String Iban;

	private String BIC;

	private Client Proprietaire;

	public String getIban() {
		return Iban;
	}

	public void setIban(String iban) {
		Iban = iban;
	}

	public String getBIC() {
		return BIC;
	}

	public void setBIC(String bIC) {
		BIC = bIC;
	}

	public Client getProprietaire() {
		return Proprietaire;
	}

	public void setProprietaire(Client proprietaire) {
		Proprietaire = proprietaire;
	}

	public void setProprietaire(String string) {
		// TODO Auto-generated method stub
		
	}

}
