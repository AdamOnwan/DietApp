package com.onwan.dietapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onwan.dietapp.entities.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

	List<Equipment> findByUsersId(int id);
	
}