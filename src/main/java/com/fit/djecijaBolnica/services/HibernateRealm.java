package com.fit.djecijaBolnica.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fit.djecijaBolnica.entities.User;

public class HibernateRealm extends AuthorizingRealm {

	protected final Session session;

	public HibernateRealm(Session session) {
		super(new MemoryConstrainedCacheManager());
		this.session = session;
		setAuthenticationTokenClass(UsernamePasswordToken.class);
		setCredentialsMatcher(new SimpleCredentialsMatcher());
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {

		if (principals == null)
			throw new AuthorizationException(
					"PrincipalCollection was null, which should not happen");

		if (principals.isEmpty())
			return null;

		if (principals.fromRealm(getName()).size() <= 0) {
			return null;
		}

		String username = (String) principals.fromRealm(getName()).iterator()
				.next();

		if (username == null)
			return null;

		User user = findUserByUsername(username);

		if (user == null)
			return null;

		Set<String> roles = new HashSet<String>();

		roles.add(user.getUserType().toString());

		return new SimpleAuthorizationInfo(roles);
	}

	public User findUserByUsername(String username) {
		List<User> users = session.createCriteria(User.class)
				.add(Restrictions.eq("username", username)).list();

		if (users == null || users.size() < 1) {
			throw new UnknownAccountException("username not found!");
		}

		return users.get(0);
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {

		UsernamePasswordToken upToken = (UsernamePasswordToken) token;

		String username = upToken.getUsername();

		// Null username is invalid
		if (username == null) {
			throw new AccountException(
					"Null usernames are not allowed by this realm.");
		}

		User user = findUserByUsername(username);

		if (user == null) {
			return null;
		}

		return new SimpleAuthenticationInfo(user.getUsername(),
				user.getPassword(), getName());
	}

}
