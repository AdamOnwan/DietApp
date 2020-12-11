package com.onwan.dietapp.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onwan.dietapp.entities.Address;
import com.onwan.dietapp.services.AddressService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4212" })
public class AddressController {
	
	@Autowired
	private AddressService addressSvc;
	
	@GetMapping("address")
	public List<Address> listAllAddresses(HttpServletResponse resp) {
		List<Address> addresses = addressSvc.allAddresses();
		if (addresses == null) {
			resp.setStatus(404);
		}
		return addresses;
	}
	
	@GetMapping("address/{username}")
	public List<Address> listMyAddress(Principal principal, HttpServletResponse resp) {
		List<Address> addresses = addressSvc.findAddressByEmail(principal.getName());
		if(addresses != null && addresses.size() == 0) {
			resp.setStatus(204);
		}
		if(addresses == null) {
			resp.setStatus(404);
		}
		return addresses;
	}
	@PostMapping("address/user")
	public Address create(HttpServletRequest req, HttpServletResponse res, @RequestBody Address address) {
		try {
			address = addressSvc.createAddress(address);
			if(address == null) {
				res.setStatus(401);
			} else {
				res.setStatus(201);
				StringBuffer url = req.getRequestURL();
				url.append("/").append(address.getId());
				res.addHeader("Location", url.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(500);
			address = null;
		}
		return address;
	}

}
