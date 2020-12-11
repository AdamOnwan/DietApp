package com.onwan.dietapp.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReservationTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Reservation reservation;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("DietApp");
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}
	
	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		reservation = em.find(Reservation.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		reservation = null;
		em.close();
	}

	@Test
	@DisplayName("reservation entity id field")
	void test_Reservation_entity_id_field() {
		assertEquals(1, reservation.getId());
	}
	
	@Test
	@DisplayName("reservation entity openDate field")
	void test_Reservation_entity_openDate_field() {
		assertEquals("2020-01-10 22:00:00.0", reservation.getOpenDate().toString());
	}
	
	@Test
	@DisplayName("reservation entity closeDate field")
	void test_Reservation_entity_closeDate_field() {
		assertEquals("2020-01-20 23:00:00.0", reservation.getCloseDate().toString());
	}
	
	@Test
	@DisplayName("reservation entity completed field")
	void test_Reservation_entity_completed_field() {
		assertEquals(true, reservation.getCompleted());
	}
	
	@Test
	@DisplayName("reservation entity createdAt field")
	void test_Reservation_entity_createdAt_field() {
		assertEquals("2020-01-08 10:00:00.0", reservation.getCreatedAt().toString());
	}
	
	@Test
	@DisplayName("reservation entity closedAt field")
	void test_Reservation_entity_closedAt_field() {
		assertEquals("2020-01-20 23:00:00.0", reservation.getCloseDate().toString());
	}
	
	@Test
	@DisplayName("reservation entity approved field")
	void test_Reservation_entity_approved_field() {
		assertEquals(true, reservation.getApproved());
	}

}
