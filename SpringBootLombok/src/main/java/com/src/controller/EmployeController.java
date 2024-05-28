package com.src.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.entity.Member;
import com.src.service.MemberService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/m")
public class EmployeController {
	@Autowired
	private MemberService memberService;

	@GetMapping
	public ResponseEntity<?> findall() {
		return new ResponseEntity<List<Member>>(memberService.findall(), HttpStatus.OK);

	}

	@GetMapping("{id}")
	public ResponseEntity<?> findbyid(@PathVariable("id") Integer id) {
		return new ResponseEntity<Member>(memberService.findbyid(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> add(@Valid @RequestBody Member member) {
		Member geekEmployeop = memberService.add(member);
		return new ResponseEntity<Member>(geekEmployeop, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody Member member) {
		Member m = memberService.update(member);
		return new ResponseEntity<Member>(m, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deletebyid(@PathVariable("id") Integer id) {
		memberService.deletebyid(id);
		return new ResponseEntity<String>("delete success", HttpStatus.OK);
	}
}
