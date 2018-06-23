package net.joastbg.sampleapp.entities;

public class CompteBancaire {

	private String Iban;

	private String BIC;

	private Client Proprietaire;

	public String getIban() {
		return Iban;
	}

	public void setIban(String iban) {
		Iban = iban;
	}

	public String getBIC() {
		return BIC;
	}

	public void setBIC(String bIC) {
		BIC = bIC;
	}

	public Client getProprietaire() {
		return Proprietaire;
	}

	public void setProprietaire(Client proprietaire) {
		Proprietaire = proprietaire;
	}

	public void setProprietaire(String string) {
		// TODO Auto-generated method stub
		
	}

}
