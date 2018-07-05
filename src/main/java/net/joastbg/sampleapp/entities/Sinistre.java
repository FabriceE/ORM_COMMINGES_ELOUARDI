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
@Table(name = "SINISTRE")
public class Sinistre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idSinitre")
	private int idSinitre;
	
	@Column(name = "dateSinistre")
	private Date date;

	@Column(name = "titre")
	private String titre;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "idAssurance")
	private Assurance assurance;

	public Sinistre(Date date, String titre, String description, Assurance assurance) {
		this.date = date;
		this.titre = titre;
		this.description = description;
		this.assurance = assurance;
	}

	protected Date getDate() {
		return date;
	}

	protected void setDate(Date date) {
		this.date = date;
	}

	protected String getTitre() {
		return titre;
	}

	protected void setTitre(String titre) {
		this.titre = titre;
	}

	protected String getDescription() {
		return description;
	}

	protected void setDescription(String description) {
		this.description = description;
	}

	protected Assurance getAssurance() {
		return assurance;
	}

	protected void setAssurance(Assurance assurance) {
		this.assurance = assurance;
	}

}
