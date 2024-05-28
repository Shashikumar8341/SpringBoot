package com.src.entity;

public class Address {

	private int a_id;
	private String a_area;

	
	public Address() {
		super();
	}

	public Address(int a_id, String a_area) {
		super();
		this.a_id = a_id;
		this.a_area = a_area;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getA_area() {
		return a_area;
	}

	public void setA_area(String a_area) {
		this.a_area = a_area;
	}

	@Override
	public String toString() {
		return "Address [a_id=" + a_id + ", a_area=" + a_area + "]";
	}

}
