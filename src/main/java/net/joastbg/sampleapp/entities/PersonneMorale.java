package net.joastbg.sampleapp.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
@DiscriminatorValue(value = "true")
public class PersonneMorale extends Client {

	@Column(name = "siren")
	private int siren;

	@Column(name = "nom")
	private String nom;

	public PersonneMorale() {
	}

	public PersonneMorale(int siren, String nom) {
		setSiren(siren);
		setNom(nom);
	}

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
