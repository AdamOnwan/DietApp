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

class ServiceTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Service service;
	
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
		service = em.find(Service.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		service = null;
		em.close();
	}
	
	@Test
	@DisplayName("service entity id field")
	void test_Service_entity_id_field() {
		assertEquals(1, service.getId());
	}
	
	@Test
	@DisplayName("service entity name field")
	void test_Service_entity_name_field() {
		assertEquals("diet advice", service.getName());
	}
	
	@Test
	@DisplayName("service entity description field")
	void test_Service_entity_description_field() {
		assertEquals("great diet advice for you", service.getDescription());
	}
	
	@Test
	@DisplayName("service entity price field")
	void test_Service_entity_price_field() {
		assertEquals(14.99, service.getPrice());
	}
	
	@Test
	@DisplayName("service entity available field")
	void test_Service_entity_available_field() {
		assertEquals(true, service.getAvailable());
	}
	
	@Test
	@DisplayName("service entity imageUrl field")
	void test_Service_entity_imageUrl_field() {
		assertEquals(null, service.getImageUrl());
	}
	
	@Test
	@DisplayName("service entity imageUrl2 field")
	void test_Service_entity_imageUrl2_field() {
		assertEquals(null, service.getImageUrl2());
	}
	
	@Test
	@DisplayName("service entity imageUrl3 field")
	void test_Service_entity_imageUrl3_field() {
		assertEquals(null, service.getImageUrl3());
	}
	
	@Test
	@DisplayName("service entity category field")
	void test_Service_entity_category_field() {
		assertEquals(null, service.getCategory());
	}
}