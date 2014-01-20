package com.fit.djecijaBolnica.pages.doktor;

import java.util.List;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.fit.djecijaBolnica.pages.Admin;
import com.fit.djecijaBolnica.pages.admin.DodajKorisnika;
import com.fit.djecijaBolnica.entities.DoktorSpec;

public class DodajDr {

	@Inject
	private Session session;
	@Property
	private DoktorSpec dr;

	@Inject
	private AlertManager info;

	@Property
	private String password2;

	private Class nextPage = null;

	@CommitAfter
	Object onSuccess() {

		List<DoktorSpec> lista = session.createCriteria(DoktorSpec.class).list();

		for (int i = 0; i < lista.size(); i++) {

			if (lista.get(i).getUsername().equals(dr.getUsername())) {
				info.error("Username exists!");
				nextPage = DodajKorisnika.class;
				return nextPage;
			}
		}

		if (dr.getPassword().equals(password2)) {
			session.save(dr);
			info.info("User is added!!!");
			return Admin.class;
		} else {
			info.error("Passwords doesn't match!");
			nextPage = DodajDr.class;
			return nextPage;
		}
	}
}
