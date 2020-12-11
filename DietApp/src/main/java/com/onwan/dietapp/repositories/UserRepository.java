package com.onwan.dietapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onwan.dietapp.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findUserByEmail(String email);

	User findEquipmentByEmail(String email);

	User findFoodByEmail(String email);

	User findAllergyByEmail(String email);

	User findAddressByEmail(String email);

	User findDietByEmail(String email);
}