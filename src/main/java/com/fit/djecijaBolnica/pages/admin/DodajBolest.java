package com.fit.djecijaBolnica.pages.admin;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.fit.djecijaBolnica.entities.Bolest;
import com.fit.djecijaBolnica.pages.Admin;
import com.fit.djecijaBolnica.pages.Index;

public class DodajBolest {

	@Inject
	private Session session;

	@Property
	private Bolest bolest;

	@InjectPage
	private Index index;

	@Inject
	private AlertManager manager;

	@CommitAfter
	Object onSuccess() {
		session.save(bolest);
		return Admin.class;

	}
}
