package net.joastbg.sampleapp.entities;

import java.util.List;

public abstract class Client  {

	private int identifiant;

	private List<CompteBancaire> comptes;

	private CompteBancaire comptePrincipal;

	private List<Contact> contacts;

	private List<Assurance> assurances;

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public List<CompteBancaire> getComptes() {
		return comptes;
	}

	public void setComptes(List<CompteBancaire> comptes) {
		this.comptes = comptes;
	}

	public CompteBancaire getComptePrincipal() {
		return comptePrincipal;
	}

	public void setComptePrincipal(CompteBancaire comptePrincipal) {
		this.comptePrincipal = comptePrincipal;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Assurance> getAssurances() {
		return assurances;
	}

	public void setAssurances(List<Assurance> assurances) {
		this.assurances = assurances;
	}

}
