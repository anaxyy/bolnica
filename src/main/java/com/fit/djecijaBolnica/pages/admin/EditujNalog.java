package com.fit.djecijaBolnica.pages.admin;

import javax.inject.Inject;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.fit.djecijaBolnica.entities.User;

public class EditujNalog {
	
	@Property
	@Persist
	private User user;
	
	@Inject
	private Session session;

	@InjectComponent
	private Zone zone;

	@Inject
	private AlertManager alertManager;
	
	
	
	public User findById(Long id) {

		if (id != null) {
			return (User) session.get(User.class, id);

		} else {
			return null;
		}

	}
	
	Object onActivate (Long id){
		user = findById(id);
		return null;
	}


	@CommitAfter
	Object onSuccess() {
		session.update(user);
		alertManager.info("The account is edited!!!");
		return null;

	}
	
}
