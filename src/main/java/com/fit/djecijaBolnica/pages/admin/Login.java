package com.fit.djecijaBolnica.pages.admin;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.fit.djecijaBolnica.entities.User;
import com.fit.djecijaBolnica.pages.Admin;
import com.fit.djecijaBolnica.pages.Doktor;
import com.fit.djecijaBolnica.pages.Index;
import com.fit.djecijaBolnica.pages.MedSestra;
import com.fit.djecijaBolnica.pages.Upravnik;
import com.fit.djecijaBolnica.services.Security;

public class Login {

	@Property
	private String userName;
	@Property
	private String password;

	@Inject
	private Session session;

	@SessionState
	private User user;

	@Inject
	private AlertManager alert;

	Object onSubmitFromLoginForm() {
		System.out.println("In login form submit event handler!");
		Class nextPage = null;
		User authenticatedUser = Security.authenticate(userName, password,
				session);
		if (authenticatedUser != null) {

			System.out.println("Authentication succeeded!");
			user = authenticatedUser;
			
			if (user.getUserType().equals("MEDICINSKA_SESTRA")) {
				nextPage = MedSestra.class;
			}

			if (user.getUserType().equals("ADMIN")) {
				nextPage = Admin.class;
			}
			if (user.getUserType().equals("UPRAVNIK")) {
				nextPage = Upravnik.class;
			}
			if (user.getUserType().equals("DOKTOR")) {
				nextPage = Doktor.class;
			}
			
		} else {
			System.out.println("Authentication failed!");
			alert.info("Authentication failed!");
			// nextPage = DodajKorisnika.class;
		}

		return nextPage;
	}
}
