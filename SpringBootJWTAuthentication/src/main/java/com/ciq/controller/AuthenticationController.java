package com.ciq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.ciq.filter.JwtUtil;
import com.ciq.response.AuthenticationRequest;
import com.ciq.response.AuthenticationResponse;
import com.ciq.service.CustomUserDetailsService;

@RestController

public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/auth")
	public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
				authenticationRequest.getPassword()));

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);

		return new AuthenticationResponse(jwt);
	}
}
