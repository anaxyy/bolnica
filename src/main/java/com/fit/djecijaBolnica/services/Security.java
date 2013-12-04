package com.fit.djecijaBolnica.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fit.djecijaBolnica.entities.User;


public class Security {

	public static User authenticate(String userName, String password, Session session)
    {
    	User login = null;
    	List users;
    	
    	// Provjera user name-a i password-a
    	users = session.createCriteria(User.class).add(Restrictions.eq("username", userName)).list();
    	if (users.size() == 0) return null;
    	login = (User) users.get(0);
    	if (login == null) return null;
        if (login.getPassword().equals(password))
        {
            return login;
        }
        return null;
    }
}
