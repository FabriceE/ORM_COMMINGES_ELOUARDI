package net.joastbg.sampleapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPTE_BANCAIRE")
public class CompteBancaire {

	@Id
	@Column(name = "iban")
	private String Iban;

	@Column(name = "BIC")
	private String BIC;

	@ManyToOne
	@JoinColumn(name = "idClient")
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

}
