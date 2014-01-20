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
@Table (name="pacijent")
public class Pacijent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual
	@Column(name = "pacient_id")
	private Long id;

	@NonVisual
	@Column(name = "data_activity")
	private boolean deleted;

	@Validate("required")
	@Column(name = "name", nullable = false)
	private String ime;

	@Validate("required")
	@Column(name = "parentName", nullable = false)
	private String imeRoditelja;
	
	@Validate("required")
	@Column(name = "lastname", nullable = false)
	private String prezime;
	
	@Validate("required")
	@Column(name = "pol", nullable = false)
	private Gender pol;
	
	@Validate("required")
	@Column(name = "birthDate", nullable = false)
	private java.util.Date datumRodjenja;
	
	@Validate("required")
	@Column(name = "JMBG", nullable = false)
	private String JMBG;
	
	@Validate("required")
	@Column(name = "krvnaGrupa", nullable = false)
	private KrvnaGrupa krvnaGrupa;
	
	
//	@Validate("required")
//	@ManyToOne(optional = false)
//	@JoinColumn(name = "pacijent_user_id")
//	private User izabraniDoktor;
	

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getImeRoditelja() {
		return imeRoditelja;
	}

	public void setImeRoditelja(String imeRoditelja) {
		this.imeRoditelja = imeRoditelja;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public Gender getPol() {
		return pol;
	}

	public void setPol(Gender pol) {
		this.pol = pol;
	}

	public java.util.Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(java.util.Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}



//	public User getIzabraniDoktor() {
//		return izabraniDoktor;
//	}
//
//	public void setIzabraniDoktor(User izabraniDoktor) {
//		this.izabraniDoktor = izabraniDoktor;
//	}

	public KrvnaGrupa getKrvnaGrupa() {
		return krvnaGrupa;
	}

	public void setKrvnaGrupa(KrvnaGrupa krvnaGrupa) {
		this.krvnaGrupa = krvnaGrupa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}



	
	
	

}
