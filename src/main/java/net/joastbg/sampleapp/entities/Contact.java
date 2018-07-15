package net.joastbg.sampleapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT")
public class Contact {

	@Id
	@Column(name = "idContact")
	private int idContact;

	@Column(name = "typeContact")
	private TypeContact type;

	@Column(name = "valeur")
	private String valeur;

	public Contact() {
	}

	protected Contact(TypeContact type, String valeur) {
		this.type = type;
		this.valeur = valeur;
	}

	protected TypeContact getType() {
		return type;
	}

	protected void setType(TypeContact type) {
		this.type = type;
	}

	protected String getValeur() {
		return valeur;
	}

	protected void setValeur(String valeur) {
		this.valeur = valeur;
	}

}
