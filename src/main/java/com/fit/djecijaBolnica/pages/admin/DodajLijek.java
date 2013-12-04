package com.fit.djecijaBolnica.pages.admin;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.fit.djecijaBolnica.entities.Lijek;
import com.fit.djecijaBolnica.pages.Index;

public class DodajLijek {

	@Inject
	private Session session;

	@Property
	private Lijek lijek;

	@InjectPage
	private Index index;

	@Inject
	private AlertManager manager;

	@CommitAfter
	Object onSuccess() {
		session.save(lijek);
		return index; 

	}
}
