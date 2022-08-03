package com.credifamilia.crud.infrastructure.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "client")
public class ClientEntity implements Serializable {

    @Id
    private String documentNumber;

    @Column
    @NotBlank(message = "Document type is mandatory")
    private String documentType;

    @Column
    @NotBlank(message = "First name is mandatory")
    private String firstname;

    @Column
    @NotBlank(message = "Last name is mandatory")
    private String lastname;

    @Column
    @NotNull(message = "Birthday is mandatory")
    private LocalDate birthday;

    @Column
    @NotBlank(message = "City is mandatory")
    private String city;

    @Column
    @Email(message = "Email must be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Column
    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;

    @Column
    @NotBlank(message = "Occupation is mandatory")
    private String occupation;
    
    @Column
    private boolean viable;
    
    public ClientEntity() {
		
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
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

	public boolean getViable() {
		return viable;
	}

	public void setViable(boolean viable) {
		this.viable = viable;
	}
    
}
