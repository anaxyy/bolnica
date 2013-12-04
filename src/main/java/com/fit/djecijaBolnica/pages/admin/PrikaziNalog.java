package com.fit.djecijaBolnica.pages.admin;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.fit.djecijaBolnica.entities.User;

public class PrikaziNalog{
	
	@Inject
	private Session session;
	
//	@Persist
	@Property
	private User user;
	
	
	public List<User> getUsers() {
		List<User> lista = session.createCriteria(User.class).list();
		
		for (int i = 0; i < lista.size(); i++) {
			
			if (lista.get(i).isDeleted()) {
				
				lista.remove(i--);
			}
		
		}
		System.out.println(lista.size());
		
		return lista;
	}
	
	public User findById(Long id) {

		if (id != null) {
			return (User) session.get(User.class, id);

		} else {
			return null;
		}

	}


	@CommitAfter
	Object onActionFromDelete(Long tId) {
		User t = findById(tId);
		session.update(t);
		t.setDeleted(true);
		
//		session.delete(t);
		return null;

	}

}
