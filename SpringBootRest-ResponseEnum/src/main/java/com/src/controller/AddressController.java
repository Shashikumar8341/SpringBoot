package com.src.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.constants.Responsecode;
import com.src.entity.Address;
import com.src.entity.ResponseObject;
import com.src.service.AddressService;

@RestController
@RequestMapping("/rest/response")
public class AddressController {
	@Autowired
	private AddressService addressService;

	@SuppressWarnings("unused")
	@PostMapping
	private ResponseObject save(@RequestBody Address address) {
		addressService.add(address);
		ResponseObject responseObject = new ResponseObject(Responsecode.crate.code, "insert successfully");
		return responseObject;
	}

	@PutMapping
	private ResponseObject update(@RequestBody Address address) {
		addressService.add(address);
		ResponseObject responseObject = new ResponseObject(Responsecode.update.code, "update successfully");
		return responseObject;
	}

	@DeleteMapping("{a_id}")
	private ResponseObject delete(@PathVariable("a_id") Integer a_id) {
		addressService.deletebyid(a_id);
		ResponseObject responseObject = new ResponseObject(Responsecode.delete.code, "delete successfully");
		return responseObject;
	}

	@GetMapping("{a_id}")
	private ResponseObject findbyid(@PathVariable("a_id") Integer a_id) {
		Address address = addressService.findbyid(a_id);
		if (address != null) {
			ResponseObject responseObject = new ResponseObject(Responsecode.ok.code, address);
			return responseObject;
		} else {
			ResponseObject responseObject = new ResponseObject(Responsecode.notfound.code,
					"Record not found successfully");
			return responseObject;

		}
	}
	@GetMapping
	private ResponseObject findall() {
		List<Address> address = addressService.findall();
		if (address != null) {
			ResponseObject responseObject = new ResponseObject(Responsecode.ok.code, address);
			return responseObject;
		} else {
			ResponseObject responseObject = new ResponseObject(Responsecode.notfound.code,
					"no Record found ");
			return responseObject;
			
		}
	}
}
