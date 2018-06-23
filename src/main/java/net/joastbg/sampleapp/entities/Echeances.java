package net.joastbg.sampleapp.entities;

import java.util.Date;

public class Echeances {

	private double prix;

	private Date dateEmission;

	private Date datePaiement;

	private Date dateEmissionFacture;

	private Assurance assurance;

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Date getDateEmission() {
		return dateEmission;
	}

	public void setDateEmission(Date dateEmission) {
		this.dateEmission = dateEmission;
	}

	public Date getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	public Date getDateEmissionFacture() {
		return dateEmissionFacture;
	}

	public void setDateEmissionFacture(Date dateEmissionFacture) {
		this.dateEmissionFacture = dateEmissionFacture;
	}

	public Assurance getAssurance() {
		return assurance;
	}

	public void setAssurance(Assurance assurance) {
		this.assurance = assurance;
	}

}
