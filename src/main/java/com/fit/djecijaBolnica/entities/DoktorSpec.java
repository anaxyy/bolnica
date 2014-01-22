package com.fit.djecijaBolnica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;


@Entity
@Table(name="doktori")
public class DoktorSpec extends User{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual
	@Column(name = "dr_id")
	private Long id;

	
	@Validate("required")
	@Column(name = "tipDr", nullable = true)
	private String tipDr;
	

	public DoktorSpec() {
		super.setUserType(Type.DOKTOR);
			
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTipDr() {
		return tipDr;
	}


	public void setTipDr(String tipDr) {
		this.tipDr = tipDr;
	}


	
	
	

}
