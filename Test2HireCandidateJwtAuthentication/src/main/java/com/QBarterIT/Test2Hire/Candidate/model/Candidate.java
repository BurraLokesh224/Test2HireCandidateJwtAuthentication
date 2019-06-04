package com.QBarterIT.Test2Hire.Candidate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

import javax.validation.constraints.Size;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "usersdetails", uniqueConstraints = { @UniqueConstraint(columnNames = { "email", "phoneNumber" })})
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(min = 3, max = 50)
	private String firstName;

	@Size(min = 3, max = 50)
	private String lastName;

	@Size(min = 6, max = 100)
	private String fatherName;

	@Size(min = 6, max = 100)
	private String fatherOccupation;

	// @Enumerated(EnumType.STRING)
	private String gender;

	private String dateOfBirth;

	@Size(min = 6, max = 100)
	private String aadharNumber, panNumber;

	@Size(min = 6, max = 100)
	private String address;
	@Size(min = 6, max = 100)
	private String city, state;

	@Size(min = 6, max = 100)
	private String pincode;

	@Size(min = 10, max = 10)
	private String phoneNumber, alternatePhoneNumber;

	@NaturalId
	@Size(max = 50)
	@Email
	private String email;

	@Size(min = 6, max = 100)
	private String password;

	@Size(min = 6, max = 100)
	private String confirmPassword;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "candidate", fetch = FetchType.LAZY)
	private Sslc sslc;

	/*
	 * @OneToOne(cascade = CascadeType.ALL, mappedBy = "user", fetch =
	 * FetchType.LAZY) private Userpro userPro;
	 */

//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "candidate_roles", joinColumns = @JoinColumn(name = "candidate_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//	private Set<Role> roles = new HashSet<>();

	public Candidate() {
	}

	public Candidate(Long id, @Size(min = 3, max = 50) String firstName, @Size(min = 3, max = 50) String lastName,
			@Size(min = 6, max = 100) String fatherName, @Size(min = 6, max = 100) String fatherOccupation,
			String gender, String dateOfBirth, @Size(min = 6, max = 100) String aadharNumber,
			@Size(min = 6, max = 100) String panNumber, @Size(min = 6, max = 100) String address,
			@Size(min = 6, max = 100) String city, @Size(min = 6, max = 100) String state,
			@Size(min = 6, max = 100) String pincode, @Size(min = 10, max = 10) String phoneNumber,
			@Size(min = 10, max = 10) String alternatePhoneNumber, @Size(max = 50) @Email String email,
			@Size(min = 6, max = 100) String password, @Size(min = 6, max = 100) String confirmPassword) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.fatherOccupation = fatherOccupation;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.phoneNumber = phoneNumber;
		this.alternatePhoneNumber = alternatePhoneNumber;

		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFatherOccupation() {
		return fatherOccupation;
	}

	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}

	public void setAlternatePhoneNumber(String alternatePhoneNumber) {
		this.alternatePhoneNumber = alternatePhoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Sslc getSslc() {
		return sslc;
	}

	public void setSslc(Sslc sslc) {
		this.sslc = sslc;
	}

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

}