package net.joastbg.sampleapp.entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class Client {

	private int identifiant;

	private List<CompteBancaire> comptes;

	private CompteBancaire comptePrincipal;

	private List<Contact> contacts;

	private List<Assurance> assurances;

	public void demandeResiliation(int numAssu) {
		assurances.get(numAssu).setResiliation(true);
	}

	public void annuleResiliation(int numAssu) {
		assurances.get(numAssu).setResiliation(false);
	}

	public void imprimerEcheances() {
		List<Echeances> echeances = new ArrayList<>();
		int diffDate = 0;
		Date dateActuelle = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		Calendar echeancesCal = null, todayCal = DateToCalendar(dateActuelle);
		for (Assurance assu : assurances) {
			for (Echeances eche : assu.getEcheances()) {
				echeancesCal = DateToCalendar(eche.getDateEmission());
				diffDate = CompareCalendars(todayCal, echeancesCal);
				if (diffDate >= 0 && diffDate <= 6) {
					echeances.add(eche);
				}
			}
		}

	}

	public int CompareCalendars(Calendar cal1, Calendar cal2) {
		if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) {
			return Math.abs(cal1.get(Calendar.MONTH) - cal2.get(Calendar.MONTH));
		} else {
			int diffYear = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
			return diffYear * 12 + cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH);
		}
	}

	public Calendar DateToCalendar(Date date) {
		Calendar cal = null;
		try {
			DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			date = (Date) formatter.parse(date.toString());
			cal = Calendar.getInstance();
			cal.setTime(date);
		} catch (ParseException e) {
			System.out.println("Exception :" + e);
		}
		return cal;
	}

	public void setComptePrincipal(String iban) {
		int i = 0;
		CompteBancaire compte;
		do {
			compte = comptes.get(i++);
			if (compte.getIban() == iban) {
				setComptePrincipal(compte);
			}
		} while (compte.getIban() != iban && i < comptes.size());
	}

	public void addContact(TypeContact type, String valeur) {
		Contact contact = new Contact(type, valeur);
		addContact(contact);
	}

	public void addContact(Contact contact) {
		contacts.add(contact);
	}

	public void deleteContact(Contact contact) {
		int i = 0;
		Contact contact2 = contacts.get(i++);

		while (!contact2.equals(contact) && i < contacts.size()) {
			contact2 = contacts.get(i++);
		}
		if (contact2.equals(contact)) {
			contacts.remove(i);
		}
	}

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
