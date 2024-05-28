package com.src.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.src.entity.Address;
import com.src.service.AddressService;

@Controller
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/add")
	public String add() {
		return "add";
	}

	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String save(Address address) {
		System.out.println(address);
		addressService.add(address);
		return "redirect:/findall";
	}

	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String update(Address address) {
		System.out.println(address);
		addressService.update(address);
		return "redirect:/findall";
	}

	@RequestMapping("/findall")
	public String findall(Model model) {
		List<Address> addresses = addressService.findall();
		model.addAttribute("addresses", addresses);
		return "findall";
	}

	@RequestMapping("/deletebyid")
	public String deletebyid(@RequestParam("a_area") String a_area) {
		addressService.deletebyid(a_area);
		return "redirect:/findall";
	}

	@RequestMapping("/updatebyid")
	public String updatebyIid(@RequestParam("a_area") String a_area, Model model) {
		Address address = addressService.findbyid(a_area);
		model.addAttribute("address", address);
		return "update";
	}

	
}
