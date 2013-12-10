package com.fit.djecijaBolnica.pages;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.apache.tapestry5.annotations.Property;

@RequiresRoles(value = { "UPRAVNIK" })
public class Upravnik
{
//	@Inject
//	private Session session;
	
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
