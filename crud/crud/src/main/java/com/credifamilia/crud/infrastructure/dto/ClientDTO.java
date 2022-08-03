package com.credifamilia.crud.infrastructure.dto;

import java.util.Date;
import java.time.LocalDate;

public class ClientDTO {
	private String documentNumber;
	private String documentType;
	private String firstname;
	private String lastname;
	private Date birthday;
	private String city;
	private String email;
	private String phoneNumber;
	private String occupation;
	private boolean viable;
	
	public ClientDTO(String documentNumber, String documentType, String firstname, String lastname, Date birthday,
			String city, String email, String phoneNumber, String occupation) {
		super();
		this.documentNumber = documentNumber;
		this.documentType = documentType;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.city = city;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.occupation = occupation;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public boolean isViable() {
		return viable;
	}

	public void setViable(boolean viable) {
		this.viable = viable;
	}
	
	
}
