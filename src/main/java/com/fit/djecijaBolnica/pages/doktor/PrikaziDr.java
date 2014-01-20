package com.fit.djecijaBolnica.pages.doktor;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.fit.djecijaBolnica.entities.DoktorSpec;
import com.fit.djecijaBolnica.entities.User;

public class PrikaziDr {
	
	@Inject
	private Session session;
	
//	@Persist
	@Property
	private DoktorSpec dr;
	
	
	public List<DoktorSpec> getDoktori() {
		List<DoktorSpec> lista = session.createCriteria(DoktorSpec.class).list();
		
		for (int i = 0; i < lista.size(); i++) {
			
			if (lista.get(i).isDeleted()) {
				
				lista.remove(i--);
			}
		
		}
		System.out.println(lista.size());
		
		return lista;
	}
	
	public DoktorSpec findById(Long id) {

		if (id != null) {
			return (DoktorSpec) session.get(DoktorSpec.class, id);

		} else {
			return null;
		}

	}


	@CommitAfter
	Object onActionFromDelete(Long tId) {
		DoktorSpec t = findById(tId);
		session.update(t);
		t.setDeleted(true);
		
//		session.delete(t);
		return null;

	}


}
