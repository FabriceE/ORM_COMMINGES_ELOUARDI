package net.joastbg.sampleapp.entities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ASSURANCE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "atype")
@DiscriminatorValue(value = "true")
public abstract class Assurance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idAssurance")
	private int numero;

	@Column(name = "dateSouscription")
	private Date dateSouscription;

	@Column(name = "dateAnniversaire")
	private Date dateAnniversaire;

	@Column(name = "datePrelevement")
	private Date datePrelevement;

	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;

	@Column(name = "resilitation")
	private boolean resiliation;

	@OneToMany
	@JoinColumn(name = "idEcheance")
	private List<Echeances> echeances;

	@OneToMany
	@JoinColumn(name = "idSinistre")
	private List<Sinistre> sinistres;

	public void activationResiliation() {
		Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		if (date.equals(dateAnniversaire) && resiliation) {
			dateAnniversaire = null;
			datePrelevement = null;
		}
	}

	public boolean getResiliation() {
		return resiliation;
	}

	public void setResiliation(boolean b) {
		resiliation = b;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDateSouscription() {
		return dateSouscription;
	}

	public void setDateSouscription(Date dateSouscription) {
		this.dateSouscription = dateSouscription;
	}

	public Date getDateAnniversaire() {
		return dateAnniversaire;
	}

	public void setDateAnniversaire(Date dateAnniversaire) {
		this.dateAnniversaire = dateAnniversaire;
	}

	public Date getDatePrelevement() {
		return datePrelevement;
	}

	public void setDatePrelevement(Date datePrelevement) {
		this.datePrelevement = datePrelevement;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Echeances> getEcheances() {
		return echeances;
	}

	public void setEcheances(List<Echeances> echeances) {
		this.echeances = echeances;
	}

	public List<Sinistre> getSinistres() {
		return sinistres;
	}

	protected void addSinistre(Sinistre sinistre) {
		this.sinistres.add(sinistre);
	}
}
