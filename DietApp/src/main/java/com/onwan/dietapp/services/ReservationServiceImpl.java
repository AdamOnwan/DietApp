package com.onwan.dietapp.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onwan.dietapp.entities.Reservation;
import com.onwan.dietapp.entities.User;
import com.onwan.dietapp.repositories.ReservationRepository;
import com.onwan.dietapp.repositories.UserRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Reservation> findAllReservationsByUserEmail(String email) {
		User user = userRepo.findUserByEmail(email);
		List<Reservation> reservations;
		if (!user.getServices().isEmpty()) {
			reservations = reservationRepo.findByServiceId(user.getServices().get(0).getId());
			return reservations;
		} else {
			reservations = reservationRepo.findByUserId(user.getId());
		}
		return reservations;
	}

	@Override
	public Reservation createReservation(String email, Reservation reservation) {
		User user = userRepo.findUserByEmail(email);
		if (reservation.getOpenDate() == null || reservation.getCloseDate() == null) {
			return null;
		}
		if (reservation.getOpenDate().after(reservation.getCloseDate())) {
			return null;
		}
		Date today = new Date();

		if (today.after(reservation.getOpenDate())) {
			return null;
		}
		if (user != null) {
			reservation.setUser(user);
			return reservationRepo.saveAndFlush(reservation);
		} else {
			return null;
		}
	}

	@Override
	public Reservation updateUserReservation(String email, Reservation reservation, int userId) {
		Reservation oldReservation = reservationRepo.findByUserEmailAndId(email, userId);
		if (oldReservation != null) {
			oldReservation.setApproved(reservation.getApproved());
			oldReservation.setOpenDate(reservation.getOpenDate());
			oldReservation.setCloseDate(reservation.getCloseDate());
			oldReservation.setCompleted(reservation.getCompleted());
			return reservationRepo.saveAndFlush(oldReservation);
		} else {
			return null;
		}
	}

	@Override
	public Reservation updateServiceReservation(String email, Reservation reservation, int serviceId) {
		Reservation updateReservation = reservationRepo.findByServiceId_User_EmailAndId(email, serviceId);
		if (reservation != null) {
			updateReservation.setApproved(reservation.getApproved());
			updateReservation.setCompleted(reservation.getCompleted());
			reservationRepo.saveAndFlush(updateReservation);
		}
		return updateReservation;
	}
}