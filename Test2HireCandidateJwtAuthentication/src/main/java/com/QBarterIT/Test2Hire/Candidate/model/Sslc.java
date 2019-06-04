package com.QBarterIT.Test2Hire.Candidate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sslc")
public class Sslc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sslc_id")
	private Long id;
	private String board;
	private String schoolName;
	private String location;
	private String percentage;
	private String yearOfPassing;

	@Lob
	private byte[] filesslc;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	public Sslc() {

	}

	public Sslc(Long id, String board, String schoolName, String location, String percentage, String yearOfPassing,
			Candidate candidate) {
		super();
		this.id = id;
		this.board = board;
		this.schoolName = schoolName;
		this.location = location;
		this.percentage = percentage;
		this.yearOfPassing = yearOfPassing;

		this.candidate = candidate;
	}

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

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public byte[] getFilesslc() {
		return filesslc;
	}

	public void setFilesslc(byte[] filesslc) {
		this.filesslc = filesslc;
	}

}
