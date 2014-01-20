package com.fit.djecijaBolnica.pages.medSestra;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.fit.djecijaBolnica.entities.Pacijent;
import com.fit.djecijaBolnica.entities.User;
import com.fit.djecijaBolnica.model.lov.user.UserEncoder;
import com.fit.djecijaBolnica.model.lov.user.UserSelectModel;
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
	
	@Persist
	@Property
	private User selectedUser;
	
	public SelectModel getUserModel() {
		return new UserSelectModel(session.createCriteria(User.class)
				.list());
	}
	
	public ValueEncoder getUserEncoder() {
		return new UserEncoder(session);
	}	



	@CommitAfter
	Object onSuccess() {
		if (pacijent.getJMBG().length() == 13) {
			pacijent.setIzabraniDoktor(selectedUser);
			session.save(pacijent);
			info.info("Pacient is added!!!");
			this.selectedUser = null;
			return MedSestra.class;
		}
		info.error("JMBG isn't ok!");
		return OtvoriKarton.class;
	}
}
