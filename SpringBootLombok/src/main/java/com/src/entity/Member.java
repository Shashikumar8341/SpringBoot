package com.src.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@NotNull
	private int id;
//	@Min(value = 18, message = "Minimum working age 18")
//	@Max(value = 60, message = "Maximum working age 60")
	private int age;
	//@NotBlank
	private String first;
	//@NotBlank
	private String last;

}
