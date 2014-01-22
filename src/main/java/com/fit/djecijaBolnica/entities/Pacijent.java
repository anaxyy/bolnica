package com.fit.djecijaBolnica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
@Table(name = "pacijent")
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
	private String imePrezime;

	@Validate("required")
	@Column(name = "parentName", nullable = false)
	private String imeRoditelja;

	@Validate("required")
	@Column(name = "pol", nullable = false)
	private Gender pol;

	@Validate("required")
	@Column(name = "telefon", nullable = false)
	private int tel;

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	@Validate("required")
	@Column(name = "birthDate", nullable = false)
	private java.util.Date datumRodjenja;

	@Validate("required")
	@Column(name = "birthPlace", nullable = false)
	private String mjestoRodjenja;

	@Validate("required")
	@Column(name = "JMBG", nullable = false)
	private String JMBG;

	@Validate("required")
	@Column(name = "address", nullable = false)
	private String adresa;

	@Validate("required")
	@Column(name = "krvnaGrupa", nullable = false)
	private KrvnaGrupa krvnaGrupa;

//
//	@Validate("required")
//	@ManyToOne(optional = false)
//	@JoinColumn(name = "pacijent_dr_id")
//	private DoktorSpec doktor;

	public String getMjestoRodjenja() {
		return mjestoRodjenja;
	}

	public void setMjestoRodjenja(String mjestoRodjenja) {
		this.mjestoRodjenja = mjestoRodjenja;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getImeRoditelja() {
		return imeRoditelja;
	}

	public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}

	public void setImeRoditelja(String imeRoditelja) {
		this.imeRoditelja = imeRoditelja;
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

//	public DoktorSpec getDoktor() {
//		return doktor;
//	}
//
//
//	public void setDoktor(DoktorSpec dr) {
//		this.doktor = dr;
//
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
