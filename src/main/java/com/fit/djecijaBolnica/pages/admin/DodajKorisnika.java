package com.fit.djecijaBolnica.pages.admin;

import java.util.List;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.fit.djecijaBolnica.entities.User;
import com.fit.djecijaBolnica.pages.Admin;

public class DodajKorisnika {

	@Inject
	private Session session;
	/*
	 * 
	 * testtestasdasdasds
	 */
	@Property
	private User user;
	
	@Inject
	private AlertManager info;
	
	@Property
	private String password2;
	
	private Class nextPage = null;
	
	@CommitAfter
	Object onSuccess(){
		
		List<User> lista = session.createCriteria(User.class).list();
		
		for (int i = 0; i < lista.size(); i++) {
			
			if (lista.get(i).getUsername().equals(user.getUsername())) {
				info.error("Username exists!");
				nextPage = DodajKorisnika.class;
				return nextPage;
			}
		}
		
		if(user.getPassword().equals(password2)){
			session.save(user);
			info.info("User is added!!!");
			nextPage = Login.class;
			return nextPage;
		}else{
			info.error("Passwords doesn't match!");
			nextPage = DodajKorisnika.class;
			return nextPage;
		}
	}
}
