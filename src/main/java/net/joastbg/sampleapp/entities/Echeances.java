package net.joastbg.sampleapp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ECHEANCES")
public class Echeances {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idEcheance")
	private int idEcheance;

	@Column(name = "prix")
	private double prix;

	@Column(name = "dateEmission")
	private Date dateEmission;

	@Column(name = "datePaiement")
	private Date datePaiement;

	@Column(name = "dateEmissionFacture")
	private Date dateEmissionFacture;

	@ManyToOne
	@JoinColumn(name = "idAssurance")
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
