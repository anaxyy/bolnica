package com.fit.djecijaBolnica.pages.medSestra;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.fit.djecijaBolnica.entities.DoktorSpec;
import com.fit.djecijaBolnica.entities.Pacijent;
import com.fit.djecijaBolnica.model.lov.doktor.DoktorEncoder;
import com.fit.djecijaBolnica.model.lov.doktor.DoktorSelectModel;
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
	
	@Persist
	@Property
	private DoktorSpec selectedDoktor;
	
	public SelectModel getDoktorModel() {
		return new DoktorSelectModel(session.createCriteria(DoktorSpec.class)
				.list());
	}

	public ValueEncoder getDoktorEncoder() {
		return new DoktorEncoder(session);
	}
	

	@CommitAfter
	Object onSuccess() {
		if (pacijent.getJMBG().length() == 13) {
			pacijent.setDoktor(selectedDoktor);
			session.save(pacijent);
			info.info("Pacient is added!!!");
			this.selectedDoktor=null;
			return MedSestra.class;
		}
		info.error("JMBG isn't ok!");
		return OtvoriKarton.class;
	}
}
