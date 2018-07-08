package net.joastbg.sampleapp.dao;

import net.joastbg.sampleapp.entities.Assurance;
import net.joastbg.sampleapp.entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ClientDao {

	@Autowired
	SessionFactory sessionFactory;

	public int persist(Client client) {
		Session session = sessionFactory.getCurrentSession();
		int returnID = (int) session.save(client);
		return returnID;
	}

	public Client find(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Client) session.load(Client.class, id);
	}

	public List<Client> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("select identifiant, nom, prenom, dateNaissance, siren, comptePrincipal from Client").list();
	}

	public void delete(Client client) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(client);
	}

	public List<Client> getAnniversary() {
		Date dateActuelle = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		Calendar annivCal = null, todayCal = DateToCalendar(dateActuelle);
		int diffDate = 0;
		List<Client> anniversaires = new ArrayList<>();
		List<Client> clients = findAll();
		for (Client client : clients) {
			for (Assurance assu : client.getAssurances()) {
				annivCal = DateToCalendar(assu.getDateAnniversaire());
				diffDate = CompareCalendars(todayCal, annivCal);
				if (diffDate >= 0 && diffDate <= 3) {
					anniversaires.add(client);
				}
				break;
			}
		}
		return anniversaires;
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

}
