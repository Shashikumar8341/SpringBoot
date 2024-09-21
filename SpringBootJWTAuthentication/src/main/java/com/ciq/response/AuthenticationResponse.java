package com.ciq.response;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class AuthenticationResponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String jwt;

	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}

}
