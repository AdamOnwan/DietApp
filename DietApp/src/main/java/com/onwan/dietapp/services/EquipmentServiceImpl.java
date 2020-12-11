package com.onwan.dietapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onwan.dietapp.entities.Equipment;
import com.onwan.dietapp.entities.User;
import com.onwan.dietapp.repositories.EquipmentRepository;
import com.onwan.dietapp.repositories.UserRepository;

@Service
public class EquipmentServiceImpl implements EquipmentService{
	
	@Autowired
	private EquipmentRepository equipmentRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<Equipment> listAllEquipment() {
		return equipmentRepo.findAll();
	}
	
	@Override
	public List<Equipment> findAllEquipmentByEmail(String email) {
		User user = userRepo.findEquipmentByEmail(email);
		List<Equipment> equipment;
		equipment = equipmentRepo.findByUsersId(user.getId());
		return equipment;
	}
}
