package net.joastbg.sampleapp.entities;

public class PersonneMorale extends Client {

	private int siren;

	private String nom;

	public int getSiren() {
		return siren;
	}

	public void setSiren(int siren) {
		this.siren = siren;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
