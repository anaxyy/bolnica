package com.fit.djecijaBolnica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sourceforge.htmlunit.corejs.javascript.ast.IfStatement;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.If;


@Entity
@Table(name="doktori")
public class DoktorSpec {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual
	@Column(name = "dr_id")
	private Long id;
	
	
	@Validate("required")
	@Column(name = "tipDr", nullable = true)
	private String tipDr;
	
	public String getTipDr() {
		return tipDr;
	}

	public void setTipDr(String tipDr) {
		this.tipDr = tipDr;
	}
	
	

}
