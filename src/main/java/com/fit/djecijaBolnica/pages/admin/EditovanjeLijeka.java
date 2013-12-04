package com.fit.djecijaBolnica.pages.admin;

import javax.inject.Inject;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.fit.djecijaBolnica.entities.Lijek;

public class EditovanjeLijeka {
	
	@Property
	@Persist
	private Lijek lijek;
	
	@Inject
	private Session session;

	@InjectComponent
	private Zone zone;

	@Inject
	private AlertManager alertManager;
	
	
	
	public Lijek findById(Long id) {

		if (id != null) {
			return (Lijek) session.get(Lijek.class, id);

		} else {
			return null;
		}

	}
	
	Object onActivate (Long id){
		lijek = findById(id);
		return null;
	}


	@CommitAfter
	Object onSuccess() {
		session.update(lijek);
		alertManager.info("The cure is edited!!!");
		return null;

	}
	
}
