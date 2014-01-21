package com.fit.djecijaBolnica.pages.medSestra;

import javax.inject.Inject;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.fit.djecijaBolnica.entities.Pacijent;

public class EditKarton {
	
	@Property
	@Persist
	private Pacijent pacijent;
	
	@Inject
	private Session session;

	@InjectComponent
	private Zone zone;

	@Inject
	private AlertManager alertManager;
	
	
	
	public Pacijent findById(Long id) {

		if (id != null) {
			return (Pacijent) session.get(Pacijent.class, id);

		} else {
			return null;
		}

	}
	
	Object onActivate (Long id){
		pacijent = findById(id);
		return null;
	}


	@CommitAfter
	Object onSuccess() {
		session.update(pacijent);
		alertManager.info("Podaci o pacijentu su promjenjeni!!!");
		return null;

	}
	
}
