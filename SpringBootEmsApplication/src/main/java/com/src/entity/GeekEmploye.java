package com.src.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class GeekEmploye {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "Enter a valid Employee Id")
	private Long Emp_id;

	@NotNull(message = "Must not be Empty and NULL")
	private String phoneNumber;

	@NotNull(message = "Employee name can't be left empty")
	private String geekEmployeeName;

	@Min(value = 18, message = "Minimum working age 18")
	@Max(value = 60, message = "Maximum working age 60")
	private Integer age;

	@Email(message = "Please enter a valid email Id")
	@NotNull(message = "Email cannot be NULL")
	private String geekEmailId;

	@Pattern(regexp = "^[0-9]{5}$", message = "Employee postal code must be a 5-digit number.")
	private String employeePostalCode;

	@Size(min = 10, max = 100, message = "Address should have a length between 10 and 100 characters.")
	private String employeeAddress;

	/**
	 * @param emp_id
	 * @param phoneNumber
	 * @param geekEmployeeName
	 * @param age
	 * @param geekEmailId
	 * @param employeePostalCode
	 * @param employeeAddress
	 */
	public GeekEmploye(@NotNull(message = "Enter a valid Employee Id") Long emp_id,
			@NotNull(message = "Must not be Empty and NULL") String phoneNumber,
			@NotNull(message = "Employee name can't be left empty") String geekEmployeeName,
			@Min(value = 18, message = "Minimum working age 18") @Max(value = 60, message = "Maximum working age 60") Integer age,
			@Email(message = "Please enter a valid email Id") @NotNull(message = "Email cannot be NULL") String geekEmailId,
			@Pattern(regexp = "^[0-9]{5}$", message = "Employee postal code must be a 5-digit number.") String employeePostalCode,
			@Size(min = 10, max = 100, message = "Address should have a length between 10 and 100 characters.") String employeeAddress) {
		super();
		Emp_id = emp_id;
		this.phoneNumber = phoneNumber;
		this.geekEmployeeName = geekEmployeeName;
		this.age = age;
		this.geekEmailId = geekEmailId;
		this.employeePostalCode = employeePostalCode;
		this.employeeAddress = employeeAddress;
	}

	public GeekEmploye() {
		super();
	}

	public Long getEmp_id() {
		return Emp_id;
	}

	public void setEmp_id(Long emp_id) {
		Emp_id = emp_id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGeekEmployeeName() {
		return geekEmployeeName;
	}

	public void setGeekEmployeeName(String geekEmployeeName) {
		this.geekEmployeeName = geekEmployeeName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGeekEmailId() {
		return geekEmailId;
	}

	public void setGeekEmailId(String geekEmailId) {
		this.geekEmailId = geekEmailId;
	}

	public String getEmployeePostalCode() {
		return employeePostalCode;
	}

	public void setEmployeePostalCode(String employeePostalCode) {
		this.employeePostalCode = employeePostalCode;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	@Override
	public String toString() {
		return "GeekEmploye [Emp_id=" + Emp_id + ", phoneNumber=" + phoneNumber + ", geekEmployeeName="
				+ geekEmployeeName + ", age=" + age + ", geekEmailId=" + geekEmailId + ", employeePostalCode="
				+ employeePostalCode + ", employeeAddress=" + employeeAddress + "]";
	}

}
