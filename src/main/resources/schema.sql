CREATE SEQUENCE CLIENT_SEQUENCE START WITH 20 INCREMENT BY 1;
CREATE SEQUENCE ASSURANCE_SEQUENCE START WITH 20 INCREMENT BY 1;

CREATE TABLE COMPTE_BANCAIRE(
	iban varchar(32),
	proprietaire VARCHAR (50),
	swift_code varchar(8),
	PRIMARY KEY (iban)
);


CREATE TABLE CLIENT(
	idClient INTEGER GENERATED BY DEFAULT AS IDENTITY (start with 1),
	nom varchar(20),
	primary key (idClient)
);



CREATE TABLE COMPTE_CLIENT(
  idClient INTEGER ,
  iban varchar(20),
  PRIMARY KEY (idClient, iban),
	FOREIGN KEY (idClient) REFERENCES CLIENT(idClient),
  FOREIGN KEY (iban) REFERENCES COMPTE_BANCAIRE(iban)
);


  create TABLE ASSURANCE(
    idAssurance INTEGER GENERATED BY DEFAULT AS IDENTITY (start with 1),
    typeAssurance varchar(10),
    PRIMARY KEY (idAssurance)
  );

  create TABLE CLIENT_ASSURANCE(
    idClient INTEGER ,
    idAssurance INTEGER ,
    PRIMARY KEY (idClient, idAssurance),
    FOREIGN KEY (idClient) REFERENCES CLIENT(idClient),
    FOREIGN KEY (idAssurance) REFERENCES ASSURANCE(idAssurance)
  )
