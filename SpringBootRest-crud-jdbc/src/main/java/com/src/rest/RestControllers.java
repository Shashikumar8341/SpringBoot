package com.src.rest;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.src.entity.Address;
import com.src.service.AddressService;

	@RestController
	@RequestMapping("/rest")
	public class RestControllers {

		@Autowired
		private AddressService addressService;

		@GetMapping("/findall")
		public List<Address> restFindAll() {
			List<Address> addresses = addressService.findall();
			return addresses;
		}

		@GetMapping("/findbyid")
		public Address findbyid(@RequestParam("a_id") Integer a_id) {
			Address address = addressService.findbyid(a_id);
			return address;
		}
		
		
		@DeleteMapping("/deletebyid/{a_id}")
		public String deletebyid(@PathVariable("a_id") Integer a_id) {
			addressService.deletebyid(a_id);
			return "Address Deleted Successfully with a_id "+a_id;
		}
		
		@PostMapping("/save")
		public String save(@RequestBody Address address) {
			addressService.add(address);
			return "address save Successfully with a_id "+address.getA_id();
		}
		
		@PutMapping("/update")
		public String update(@RequestBody Address address) {
			addressService.update(address);
			return "address updated Successfully with a_id "+address.getA_id();
		}
		
	}