package com.fit.djecijaBolnica.pages.admin;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.fit.djecijaBolnica.entities.Bolest;

public class PrikazBolesti {
	@Inject
	private Session session;

	@Persist
	@Property
	private Bolest bolest;

	public List<Bolest> getBolesti() {
		return session.createCriteria(Bolest.class).list();
	}

	public Bolest findById(Long id) {

		if (id != null) {
			return (Bolest) session.get(Bolest.class, id);

		} else {
			return null;
		}

	}

	@CommitAfter
	Object onActionFromDelete(Long tId) {
		Bolest t = findById(tId);
		session.delete(t);
		return null;

	}
}
