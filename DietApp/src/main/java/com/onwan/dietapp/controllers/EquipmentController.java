package com.onwan.dietapp.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onwan.dietapp.entities.Equipment;
import com.onwan.dietapp.services.EquipmentService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4212" })
public class EquipmentController {
	
	@Autowired
	private EquipmentService equipmentSvc;
	
	@GetMapping("equipments")
	public List<Equipment> listAllEquipment(HttpServletResponse resp) {
		List<Equipment> equipments = equipmentSvc.listAllEquipment();
		if (equipments == null) {
			resp.setStatus(404);
		}
		return equipments;
	}
	
	@GetMapping("equipment")
	public List<Equipment> listAllMyEquipment(HttpServletResponse resp, Principal principal) {
		List<Equipment> equipmentList = equipmentSvc.findAllEquipmentByEmail(principal.getName());
		if(equipmentList != null && equipmentList.size() == 0) {
			resp.setStatus(204);
		}
		if(equipmentList == null) {
			resp.setStatus(404);
		}
		return equipmentList;
	}

}
