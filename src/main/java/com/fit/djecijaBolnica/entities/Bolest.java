package com.fit.djecijaBolnica.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

public class Bolest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual
	@Column(name = "disease_id")
	private Long id;
	
	@Validate("required")
	@Column(name = "naziv", nullable = false, unique = true)
	private String naziv;

	@Validate("required")
	@Column(name = "latinski_naziv", nullable = false, unique = true)
	private String latinskiNaziv;
	
	@Validate("required")
	@Column(name = "porijeklo")
	private String porijeklo; //nasledno, /steceno
	
	@Validate("required")
	@Column(name = "stadijum")
	private String stadijum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getLatinskiNaziv() {
		return latinskiNaziv;
	}

	public void setLatinskiNaziv(String latinskiNaziv) {
		this.latinskiNaziv = latinskiNaziv;
	}

	public String getPorijeklo() {
		return porijeklo;
	}

	public void setPorijeklo(String porijeklo) {
		this.porijeklo = porijeklo;
	}

	public String getStadijum() {
		return stadijum;
	}

	public void setStadijum(String stadijum) {
		this.stadijum = stadijum;
	}
	
	
	
	
	
	
}
