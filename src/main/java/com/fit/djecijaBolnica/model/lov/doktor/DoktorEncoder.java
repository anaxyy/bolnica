package com.fit.djecijaBolnica.model.lov.doktor;

import org.apache.tapestry5.ValueEncoder;
import org.hibernate.Session;

import com.fit.djecijaBolnica.entities.DoktorSpec;


public class DoktorEncoder implements ValueEncoder{
	
	private Session session;

	public DoktorEncoder(Session session) {
		super();
		this.session = session;
	}
	
	public String toClient(Object arg0) {
		return ((DoktorSpec)arg0).getId().toString();
	}

	public Object toValue(String arg0) {
		return session.load(DoktorSpec.class, new Long(arg0));
	}

}
