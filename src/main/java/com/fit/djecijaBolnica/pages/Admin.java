package com.fit.djecijaBolnica.pages;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fit.djecijaBolnica.entities.User;

@RequiresRoles(value = {"ADMIN" })
public class Admin {
	@Inject
	private Session session;
	@Property // ustvari kreira setere i getere za promjenjivu
	private String logedUser;
	
	
//	public User getUserWithUsername(String username){
//		User u = (User) session.createCriteria(User.class).add(Restrictions.eq("username", username));
//		return u;
//	}  ovo je upit - select, from, where  / da nam vrati nesto iz baze
	
	public void onActivate(){
		Subject currentUser = SecurityUtils.getSubject();
		
		logedUser = currentUser.getPrincipal().toString(); // principal uvijek vraca username ,  credentials vraca pasvord
	}
}
