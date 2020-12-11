package com.onwan.dietapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onwan.dietapp.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	Address findByUsersId(int id);
	
	List<Address> findByUsersEmail(String email);
}