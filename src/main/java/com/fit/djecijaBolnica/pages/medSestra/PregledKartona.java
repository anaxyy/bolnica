package com.fit.djecijaBolnica.pages.medSestra;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.hibernate.Session;

import com.fit.djecijaBolnica.entities.Bolest;
import com.fit.djecijaBolnica.entities.Pacijent;

public class PregledKartona {

	@Inject
	private Session session;

	@Persist
	@Property
	private Pacijent pacijent;

	public List<Pacijent> getPacijenti() {
		return session.createCriteria(Pacijent.class).list();
	}

	public Pacijent findById(Long id) {

		if (id != null) {
			return (Pacijent) session.get(Pacijent.class, id);

		} else {
			return null;
		}

	}
}
