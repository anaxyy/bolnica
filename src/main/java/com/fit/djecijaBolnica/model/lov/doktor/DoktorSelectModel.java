package com.fit.djecijaBolnica.model.lov.doktor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.util.AbstractSelectModel;

import com.fit.djecijaBolnica.entities.DoktorSpec;
import com.fit.djecijaBolnica.entities.User;



public class DoktorSelectModel extends AbstractSelectModel{
	
	private Collection<DoktorSpec> izabraniDoktor; 

	public DoktorSelectModel(Collection<DoktorSpec> doktori) {
		this.izabraniDoktor = doktori;
	}

	public List<OptionGroupModel> getOptionGroups() {
		return null;
	}

	public List<OptionModel> getOptions() {
		List<OptionModel> list = new ArrayList<OptionModel>();
		for (DoktorSpec d : izabraniDoktor) {
			list.add(new DoktorOptionModel(d));
		}
		return list;
	}

}
