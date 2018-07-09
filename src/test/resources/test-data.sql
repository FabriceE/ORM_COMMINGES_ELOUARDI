insert INTO COMPTE_BANCAIRE values('FR7630001007941234567890185','FR42892145');
insert INTO COMPTE_BANCAIRE values('FR7630004000031234567890143','FR10451124');
insert INTO COMPTE_BANCAIRE values('FR7630006000011234567890189','FR45715074');

insert into CLIENT  (nom, prenom, dateNaissance, ctype) values ('cathou', 'cathy', '1960-06-06', 'PersonnePhysique');
insert into CLIENT  (nom, prenom, dateNaissance, ctype) values ('toto', 'toto', '1985-02-01', 'PersonnePhysique');

insert INTO ASSURANCE (dateSouscription, dateAnniversaire, datePrelevement, immatriculation, bonusMalus, atype)
	values ('2018-06-01', '2019-06-01', '2018-07-01', '15-ZBS-45', 10, 'AssuranceAuto');

INSERT INTO CLIENT_ASSURANCE(idClient, idAssurance)
      values ((SELECT idClient from client where nom='cathou'),
              (SELECT idAssurance from ASSURANCE where immatriculation='15-ZBS-45'));

INSERT INTO COMPTE_CLIENT (idClient, iban) VALUES ((SELECT idClient from client where nom='cathou'),'FR7630001007941234567890185');

INSERT INTO ECHEANCES (prix, dateEmission, datePaiement, dateEmissionFacture) VALUES (125,'2018-06-06', '2018-07-09','2018-07-11');

INSERT INTO SINISTRE (dateSinistre, titre, description) VALUES ('2018-08-03','Titre Sinistre','Description Sinistre');