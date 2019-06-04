package com.QBarterIT.Test2Hire.Candidate.message.request;

import javax.persistence.Lob;

import com.QBarterIT.Test2Hire.Candidate.model.Candidate;

public class Sslcform {
	private Long id;
	private String board;
	private String schoolName;
	private String location;
	private String percentage;
	private String yearOfPassing;

	@Lob
	private byte[] filesslc;
	private Candidate candidate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(String yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

	public byte[] getFilesslc() {
		return filesslc;
	}

	public void setFilesslc(byte[] filesslc) {
		this.filesslc = filesslc;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

}
