package com.fit.djecijaBolnica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.tapestry5.beaneditor.Validate;


@Entity
@Table(name="doktori")
public class DoktorSpec extends User {
	
	public DoktorSpec() {
		super.setUserType(Type.DOKTOR);	
		
	}
	
	@Validate("required")
	@Column(name = "tipDr", nullable = true)
	private TipDr tipDr;


	public TipDr getTipDr() {
		return tipDr;
	}

	public void setTipDr(TipDr tipDr) {
		this.tipDr = tipDr;
	}
	
	
	
	

	
	

}
