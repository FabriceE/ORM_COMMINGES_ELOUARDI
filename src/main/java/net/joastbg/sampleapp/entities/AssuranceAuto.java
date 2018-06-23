package net.joastbg.sampleapp.entities;

import java.util.List;

public class AssuranceAuto extends Assurance {

	private int immatriculation;

	private int bonusMalus;

	private List<PersonnePhysique> conducteurs;

	public int getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(int immatriculation) {
		this.immatriculation = immatriculation;
	}

	public int getBonusMalus() {
		return bonusMalus;
	}

	public void setBonusMalus(int bonusMalus) {
		this.bonusMalus = bonusMalus;
	}

	public List<PersonnePhysique> getConducteurs() {
		return conducteurs;
	}

	public void setConducteurs(List<PersonnePhysique> conducteurs) {
		this.conducteurs = conducteurs;
	}

}
