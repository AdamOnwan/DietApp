package com.onwan.dietapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onwan.dietapp.entities.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer> {

}