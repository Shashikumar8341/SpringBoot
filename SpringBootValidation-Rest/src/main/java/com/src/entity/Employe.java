package com.src.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employe_id;
	@NotBlank(message = "fname should not be blank")
	private String fname;
	@NotBlank(message = "lname should not be blank")
	private String lname;
	@Pattern(regexp =" ^[0-9]{6}$",message = "we must be 6-digits")
	@NotNull(message = "postralcode should not be blank")
	private Long postralcode;
	@NotBlank(message = "address should not be blank")
	private String address;

	/**
	 * @param employe_id
	 * @param fname
	 * @param lname
	 * @param postralcode
	 * @param address
	 */
	public Employe(int employe_id, String fname, String lname, Long postralcode, String address) {
		super();
		this.employe_id = employe_id;
		this.fname = fname;
		this.lname = lname;
		this.postralcode = postralcode;
		this.address = address;
	}

	public Employe() {
		super();
	}

	public int getEmploye_id() {
		return employe_id;
	}

	public void setEmploye_id(int employe_id) {
		this.employe_id = employe_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Long getPostralcode() {
		return postralcode;
	}

	public void setPostralcode(Long postralcode) {
		this.postralcode = postralcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employe [employe_id=" + employe_id + ", fname=" + fname + ", lname=" + lname + ", postralcode="
				+ postralcode + ", address=" + address + "]";
	}

}
