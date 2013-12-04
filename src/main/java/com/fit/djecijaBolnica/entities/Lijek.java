package com.fit.djecijaBolnica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
@Table(name = "lijek")
public class Lijek {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual
	@Column(name = "cure_id")
	private Long id;

	@Validate("required")
	@Column(name = "cure_name", nullable = false, unique = true)
	private String name;

	@Validate("required")
	// tableta, kapsula, sirup, prasak,...
	@Column(name = "cure_type", nullable = false)
	private Upotreba type;

	@Validate("required")

	@Column(name = "cure_category", nullable = false)
	private Kategorija category;

	@Validate("required")
	//
	@Column(name = "cure_manufacturer", nullable = false )
	private Proizvodjac manufacturer;

	@Validate("required")
	// upotreba
	@Column(name = "cure_details", nullable = false)
	private String details;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Upotreba getType() {
		return type;
	}

	public void setType(Upotreba type) {
		this.type = type;
	}

	public Kategorija getCategory() {
		return category;
	}

	public void setCategory(Kategorija category) {
		this.category = category;
	}

	public Proizvodjac getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Proizvodjac manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
