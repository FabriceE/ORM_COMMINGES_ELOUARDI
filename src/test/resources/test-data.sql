insert INTO COMPTE_BANCAIRE values('FR7630001007941234567890185','Azerty');
insert INTO COMPTE_BANCAIRE values('FR7630004000031234567890143','toto');
insert INTO COMPTE_BANCAIRE values('FR7630006000011234567890189','toto');

insert into CLIENT  (nom) values ('cathy cathou');
insert into CLIENT  (nom) values ('toto cathou');

insert INTO ASSURANCE (dateSouscription, dateAnniversaire, datePrelevement, immatriculation, bonusMalus)
	values ('2018-06-01', '2019-06-01', '2018-07-01', '15-ZBS-45', 10);

INSERT INTO CLIENT_ASSURANCE(idClient, idAssurance)
      values ((SELECT idClient from client where nom='cathy cathou'),
              (SELECT idAssurance from ASSURANCE where immatriculation='15-ZBS-45'));

INSERT INTO COMPTE_CLIENT (idClient, iban) VALUES ((SELECT idClient from client where nom='cathy cathou'),'FR7630001007941234567890185');