package net.joastbg.sampleapp.entities;

import java.util.Date;

public class Sinistre {

	private Date date;

	private String titre;

	private String description;

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
