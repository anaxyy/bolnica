package com.fit.djecijaBolnica.model.lov.user;

import java.util.Map;

import org.apache.tapestry5.OptionModel;

import com.fit.djecijaBolnica.entities.User;

public class UserOptionModel implements OptionModel{

	private User user;

	public UserOptionModel(User user) {
		super();
		this.user= user;
	}
	
	public Map<String, String> getAttributes() {
		return null;
	}

	public String getLabel() {		
		return this.user.getUsername();
	}

	public Object getValue() {
		return this.user;
	}

	public boolean isDisabled() {
		return false;
	}
}
