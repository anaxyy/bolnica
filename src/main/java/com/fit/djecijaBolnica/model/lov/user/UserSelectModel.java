package com.fit.djecijaBolnica.model.lov.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.util.AbstractSelectModel;

import com.fit.djecijaBolnica.entities.User;



public class UserSelectModel extends AbstractSelectModel{
	
	private Collection<User> user; 

	public UserSelectModel(Collection<User> users) {
		this.user = users;
	}

	public List<OptionGroupModel> getOptionGroups() {
		return null;
	}

	public List<OptionModel> getOptions() {
		List<OptionModel> list = new ArrayList<OptionModel>();
		for (User u : user) {
			list.add(new UserOptionModel(u));
		}
		return list;
	}

}
