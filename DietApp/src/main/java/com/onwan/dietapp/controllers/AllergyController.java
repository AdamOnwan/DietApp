package com.onwan.dietapp.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onwan.dietapp.entities.Allergy;
import com.onwan.dietapp.services.AllergyService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4212" })
public class AllergyController {

	@Autowired
	private AllergyService allergySvc;

	@GetMapping("allergies")
	public List<Allergy> listAllAllergies(HttpServletResponse resp) {
		List<Allergy> allergies = allergySvc.allAllergies();
		if (allergies == null) {
			resp.setStatus(404);
		}
		return allergies;
	}

	@GetMapping("allergies/{username}")
	public List<Allergy> allergiesByUser(Principal principal, HttpServletResponse resp) {
		List<Allergy> allergies = allergySvc.showAllergiesByEmail(principal.getName());
		if (allergies != null && allergies.size() == 0) {
			resp.setStatus(204);
		}
		if (allergies == null) {
			resp.setStatus(404);
		}
		return allergies;
	}
	
	@PostMapping("allergies/users")
	public Allergy createAllergy(@RequestBody Allergy allergy, Principal principal, HttpServletResponse resp,
			HttpServletRequest req) {
		try {
			allergy = allergySvc.createAllergy(allergy);
			if(allergy == null) {
				resp.setStatus(401);
			} else {
				resp.setStatus(201);
				StringBuffer url = req.getRequestURL();
				url.append("/").append(allergy.getId());
				resp.addHeader("Location", url.toString());
			}
		} catch(Exception e) {
			e.printStackTrace();
			resp.setStatus(500);
			allergy = null;
		}
		return allergy;
	}
	
	@PutMapping("allergy/users/{aid}")
	public Allergy updateAllergy(@PathVariable("aid") int id, @RequestBody Allergy allergy, HttpServletResponse resp) {
		return allergy;
	}
}