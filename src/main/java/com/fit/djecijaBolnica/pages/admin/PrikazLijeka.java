package com.fit.djecijaBolnica.pages.admin;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.fit.djecijaBolnica.entities.Lijek;

public class PrikazLijeka{
	
	@Inject
	private Session session;
	
	@Persist
	@Property
	private Lijek lijek;
	
	
	public List<Lijek> getLijekovi() {
		return session.createCriteria(Lijek.class).list();
	}
	
	public Lijek findById(Long id) {

		if (id != null) {
			return (Lijek) session.get(Lijek.class, id);

		} else {
			return null;
		}

	}


	@CommitAfter
	Object onActionFromDelete(Long tId) {
		Lijek t = findById(tId);
		session.delete(t);
		return null;

	}

}
