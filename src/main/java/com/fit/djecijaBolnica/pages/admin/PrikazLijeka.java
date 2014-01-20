package com.fit.djecijaBolnica.pages.admin;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.fit.djecijaBolnica.entities.Lijek;

public class PrikazLijeka{
	
	@Inject
	private Session session;
	
	@Persist
	@Property
	private Lijek lijek;
	
	
	public List<Lijek> getLijekovi() {
		List<Lijek> lista =  session.createCriteria(Lijek.class).list();
		
	for (int i = 0; i < lista.size(); i++) {
			
			if (lista.get(i).isDeleted()) {
				
				lista.remove(i--);
			}
		
		}
		System.out.println(lista.size());
		
		return lista;
	}
	
	public Lijek findById(Long id) {

		if (id != null) {
			return (Lijek) session.get(Lijek.class, id);

		} else {
			return null;
		}

	}


//	@CommitAfter
//	Object onActionFromDelete(Long tId) {
//		Lijek l = findById(tId);
//		session.update(l);
//		l.setDeleted(true);
//		return null;
//
//	}

}
