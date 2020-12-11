package com.onwan.dietapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onwan.dietapp.entities.Allergy;

public interface AllergyRepository extends JpaRepository<Allergy, Integer> {

	List<Allergy> findByUsersId(int id);

}