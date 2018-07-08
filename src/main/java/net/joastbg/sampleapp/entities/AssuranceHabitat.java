package net.joastbg.sampleapp.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ASSURANCE")
@DiscriminatorValue(value = "true")
public class AssuranceHabitat extends Assurance {

	@Column(name = "adresseAssuree")
	private String adresse;

	@Column(name = "valeurCouverte")
	private double valeur;

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

}
