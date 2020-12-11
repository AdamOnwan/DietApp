package com.onwan.dietapp.services;

import java.util.List;

import com.onwan.dietapp.entities.Reservation;

public interface ReservationService {

	List<Reservation> findAllReservationsByUserEmail(String email);

	Reservation createReservation(String email, Reservation reservation);

	Reservation updateUserReservation(String email, Reservation reservation, int reservationId);

	Reservation updateServiceReservation(String email, Reservation reservation, int serviceId);

}
