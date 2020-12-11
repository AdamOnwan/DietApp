package com.onwan.dietapp.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onwan.dietapp.entities.Diet;
import com.onwan.dietapp.services.DietService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4212" })
public class DietController {
	
	@Autowired
	private DietService dietSvc;
	
	@GetMapping("diet")
	public List<Diet> listAllDiets(HttpServletResponse resp) {
		List<Diet> diets = dietSvc.allDiets();
		if (diets == null) {
			resp.setStatus(404);
		}
		return diets;
	}
	
	@GetMapping("diet/user")
	public List<Diet> dietByUser(Principal principal, HttpServletResponse resp) {
		List<Diet> diets = dietSvc.showDietByEmail(principal.getName());
		if(diets != null && diets.size() == 0) {
			resp.setStatus(204);
		}
		if(diets == null) {
			resp.setStatus(404);
		}
		return diets;
	}

}
