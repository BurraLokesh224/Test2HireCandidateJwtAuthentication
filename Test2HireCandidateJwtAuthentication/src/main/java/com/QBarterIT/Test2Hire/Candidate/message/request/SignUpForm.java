package com.QBarterIT.Test2Hire.Candidate.message.request;

import java.util.Set;

import javax.validation.constraints.*;

import org.hibernate.annotations.NaturalId;

import com.QBarterIT.Test2Hire.Candidate.model.Sslc;

public class SignUpForm {

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
	private Sslc sslc;
	

	public Sslc getSslc() {
		return sslc;
	}

	public void setSslc(Sslc sslc) {
		this.sslc = sslc;
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

	

}