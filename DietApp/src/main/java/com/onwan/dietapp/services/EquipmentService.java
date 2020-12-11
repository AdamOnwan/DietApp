package com.onwan.dietapp.services;

import java.util.List;

import com.onwan.dietapp.entities.Equipment;

public interface EquipmentService {

	List<Equipment> findAllEquipmentByEmail(String email);

	List<Equipment> listAllEquipment();

}
