package com.onwan.dietapp.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onwan.dietapp.entities.Reservation;
import com.onwan.dietapp.services.ReservationService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http:///localhost:4212"})
public class ReservationController {
	
	@Autowired
	private ReservationService resSvc;
	
	@GetMapping("reservations")
	public List<Reservation> index(Principal principal, HttpServletRequest req, HttpServletResponse resp) {
		List<Reservation> reservation = resSvc.findAllReservationsByUserEmail(principal.getName());
		if (reservation != null && reservation.size() == 0) {
			resp.setStatus(204);
		}
		if(reservation == null) {
			resp.setStatus(404);
		}
		return reservation;
	}
	
	@PostMapping("reservations")
	public Reservation createReservation(@RequestBody Reservation reservation, HttpServletRequest req,
			HttpServletResponse resp, Principal principal) {
		Reservation newReservation = resSvc.createReservation(principal.getName(), reservation);
		if (newReservation != null) {
			StringBuffer url = req.getRequestURL();
			resp.addHeader("Location", url.toString());
			resp.setStatus(201);
			return newReservation;
		} else {
			resp.setStatus(401);
			return null;
		}
	}
}
