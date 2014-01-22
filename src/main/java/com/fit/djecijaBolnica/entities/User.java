package com.fit.djecijaBolnica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

import bsh.This;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual
	@Column(name = "user_id")
	protected Long id;


	@NonVisual
	@Column(name = "data_activity")
	protected boolean deleted;

	@Validate("required")
	@Column(name = "nameLastname", nullable = false)
	protected String nameLastname;


	@Validate("required")
	@Column(name = "lastname", nullable = false)
	private String lastname;
	

	@Validate("required")
	@Column(name = "username", nullable = false, unique = true)
	protected String username;

	@Validate("required")
	@Column(name = "password", nullable = false)
	protected String password;

	@Validate("required")
	@Column(name = "user_type", nullable = false)
	@Enumerated(EnumType.STRING)
	protected Type userType;

	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	protected Gender gender;

	@Column(name = "email", nullable = false)
	protected String email;

	@Column(name = "age")
	protected int age;



	public String getNameLastname() {
		return nameLastname;
	}

	public void setNameLastname(String nameLastname) {
		this.nameLastname = nameLastname;
	}

	public Long getId() {
		return id;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Type getUserType() {
		return userType;
	}

	public void setUserType(Type userType) {
		this.userType = userType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



}
