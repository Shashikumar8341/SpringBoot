package com.src.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Students {

	@JsonProperty("full_name")
	private String name;

	@JsonProperty("user_age")
	private int age;

	public Students() {
		super();
	}

	/**
	 * @param name
	 * @param age
	 */
	public Students(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Students [name=" + name + ", age=" + age + "]";
	}

}
