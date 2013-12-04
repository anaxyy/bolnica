package com.fit.djecijaBolnica.pages;

import org.apache.tapestry5.annotations.SessionState;

import com.fit.djecijaBolnica.entities.User;



public class Logout {

	@SessionState
	private User user;

	public User getUser() {
		return user;
	}
	
	Object onActivate() {
		Class nextpage = Index.class;
		user = null;
		return nextpage;
	}

}
