package com.onwan.dietapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onwan.dietapp.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	
	List<Reservation> findByUserId(int userId);
	
	List<Reservation> findByServiceId(int serviceId);

	Reservation findByUserEmailAndId(String email, int userId);
	
	Reservation findByServiceId_User_EmailAndId(String email, int serviceId);

}