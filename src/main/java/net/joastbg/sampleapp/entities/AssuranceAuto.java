package net.joastbg.sampleapp.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ASSURANCE")
@DiscriminatorValue(value = "true")
public class AssuranceAuto extends Assurance {

	@Column(name = "immatriculation")
	private String immatriculation;

	@Column(name = "bonusMalus")
	private int bonusMalus;

	@OneToMany
	@JoinColumn(name = "idClient")
	private List<PersonnePhysique> conducteurs;

	public AssuranceAuto() {
		super();
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
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
