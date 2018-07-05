CREATE SEQUENCE CLIENT_SEQUENCE START WITH 20 INCREMENT BY 1;
CREATE SEQUENCE ASSURANCE_SEQUENCE START WITH 20 INCREMENT BY 1;

CREATE TABLE COMPTE_BANCAIRE(
	iban varchar(32) NOT NULL,
	bic varchar(50) NOT NULL,
	PRIMARY KEY (iban)
);


CREATE TABLE CLIENT(
	idClient INTEGER GENERATED BY DEFAULT AS IDENTITY (start with 1),
	nom varchar(20) NOT NULL,
	siren varchar(25),
	prenom varchar(25),
	dateNaissance date,
	iban varchar(32),
	primary key (idClient),
	FOREIGN KEY (iban) REFERENCES COMPTE_BANCAIRE(iban)
);


CREATE TABLE COMPTE_CLIENT(
  idClient INTEGER,
  iban varchar(20),
  PRIMARY KEY (idClient, iban),
  FOREIGN KEY (idClient) REFERENCES CLIENT(idClient),
  FOREIGN KEY (iban) REFERENCES COMPTE_BANCAIRE(iban)
);


create TABLE ASSURANCE(
    idAssurance INTEGER GENERATED BY DEFAULT AS IDENTITY (start with 1),
    dateSouscription DATE NOT NULL,
    dateAnniversaire DATE NOT NULL,
    datePrelevement DATE NOT NULL,
    immatriculation VARCHAR(9),
    bonusMalus INTEGER,
    adresseAssuree VARCHAR(100),
    valeurCouverte INTEGER,
    resilitation BOOLEAN,
    PRIMARY KEY (idAssurance)
);


create TABLE CLIENT_ASSURANCE(
    idClient INTEGER,
    idAssurance INTEGER,
    PRIMARY KEY (idClient, idAssurance),
    FOREIGN KEY (idClient) REFERENCES CLIENT(idClient),
    FOREIGN KEY (idAssurance) REFERENCES ASSURANCE(idAssurance)
);


CREATE TABLE SINISTRE(
	idSinistre INTEGER GENERATED BY DEFAULT AS IDENTITY (start with 1),
	dateSinistre DATE NOT NULL,
	titre VARCHAR(20) NOT NULL,
	description VARCHAR(100) NOT NULL,
	idAssurance INTEGER,
	PRIMARY KEY (idSinistre),
	FOREIGN KEY (idAssurance) REFERENCES ASSURANCE(idAssurance)
);


CREATE TABLE ECHEANCES(
	idEcheance INTEGER GENERATED BY DEFAULT AS IDENTITY (start with 1),
	prix integer NOT NULL,
	dateEmission date,
	datePaiement date,
	dateEmissionFacture date,
	idAssurance integer,
	Primary Key (idEcheance),
	Foreign Key (idAssurance) REFERENCES ASSURANCE(idAssurance)
);

CREATE TABLE CONTACT(
	idContact INTEGER GENERATED BY DEFAULT AS IDENTITY (start with 1),
	typeContact VARCHAR(20) NOT NULL,
	valeur VARCHAR(10) NOT NULL,
	idClient INTEGER,
	PRIMARY KEY (idContact),
	FOREIGN KEY (idClient) REFERENCES CLIENT(idClient)
)
