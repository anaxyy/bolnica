package com.fit.djecijaBolnica.pages.admin;

import javax.inject.Inject;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.fit.djecijaBolnica.entities.Bolest;

public class EditujBolest {

	@Property
	@Persist
	private Bolest bolest;
	
	@Inject
	private Session session;

	@InjectComponent
	private Zone zone;

	@Inject
	private AlertManager alertManager;
	
	
	
	public Bolest findById(Long id) {

		if (id != null) {
			return (Bolest) session.get(Bolest.class, id);

		} else {
			return null;
		}

	}
	
	Object onActivate (Long id){
		bolest = findById(id);
		return null;
	}


	@CommitAfter
	Object onSuccess() {
		session.update(bolest);
		alertManager.info("The disease is edited!!!");
		return null;

	}
	
}
