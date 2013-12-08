package com.fit.djecijaBolnica.pages;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.djecijaBolnica.pages.Admin;
import com.fit.djecijaBolnica.pages.Doktor;
import com.fit.djecijaBolnica.pages.MedSestra;
import com.fit.djecijaBolnica.pages.Upravnik;
@RequiresGuest
public class Login {

	@Property
	private String userName;
	
	@Property
	private String password;

	@Inject
	private AlertManager alert;

	public Object onSuccess() {
		UsernamePasswordToken token = new UsernamePasswordToken(userName,
				password);

		Subject currentUser = SecurityUtils.getSubject();

		try {
			currentUser.login(token);
		} catch (UnknownAccountException uae) {
			System.out.println("Username not found!");
			alert.info("Username not found!");

		} catch (IncorrectCredentialsException ice) {
			System.out.println("Password invalid!");
			alert.info("Password invalid!");

		} catch (AuthenticationException ae) {
			System.out.println("Authentication failed!");
			alert.info("Authentication failed!");
		}

		if (currentUser.hasRole("ADMIN")) {
			return Admin.class;
		}
		if (currentUser.hasRole("UPRAVNIK")) {
			return Upravnik.class;
		}
		if (currentUser.hasRole("DOKTOR")) {
			return Doktor.class;
		}
		if (currentUser.hasRole("MEDICINSKA_SESTRA")) {
			return MedSestra.class;
		}
		return null;
	}
}
