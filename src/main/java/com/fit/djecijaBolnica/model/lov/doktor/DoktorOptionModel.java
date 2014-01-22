package com.fit.djecijaBolnica.model.lov.doktor;

import java.util.Map;

import org.apache.tapestry5.OptionModel;

import com.fit.djecijaBolnica.entities.DoktorSpec;
import com.fit.djecijaBolnica.entities.User;

public class DoktorOptionModel implements OptionModel{

	private DoktorSpec izabraniDoktor;

	public DoktorOptionModel(DoktorSpec dok) {
		super();
		this.izabraniDoktor= dok;
	}
	
	public Map<String, String> getAttributes() {
		return null;
	}

	public String getLabel() {		
		return this.izabraniDoktor.getUsername();
	}

	public Object getValue() {
		return this.izabraniDoktor;
	}

	public boolean isDisabled() {
		return false;
	}
}
