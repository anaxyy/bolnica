package com.fit.djecijaBolnica.pages.medSestra;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.fit.djecijaBolnica.entities.Pacijent;
import com.fit.djecijaBolnica.pages.Index;
import com.fit.djecijaBolnica.pages.MedSestra;

public class OtvoriKarton {

	@Inject
	private Session session;
	@Property
	private Pacijent pacijent;

	@Inject
	private AlertManager info;

	@Inject
	private AlertManager manager;

	@CommitAfter
	Object onSuccess() {
		if (pacijent.getJMBG().length() == 13) {
			session.save(pacijent);
			info.info("Pacient is added!!!");
			return MedSestra.class;
		}
		info.error("JMBG isn't ok!");
		return OtvoriKarton.class;
	}
}
