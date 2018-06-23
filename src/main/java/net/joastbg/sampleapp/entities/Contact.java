package net.joastbg.sampleapp.entities;

public class Contact {

	private TypeContact type;

	private String valeur;

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
