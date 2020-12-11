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

class AddressTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Address address;
	
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
		address = em.find(Address.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		address = null;
		em.close();
	}

	@Test
	@DisplayName("address entity id field")
	void test_Address_entity_id_field() {
		assertEquals(1, address.getId());
	}
	
	@Test
	@DisplayName("address entity address field")
	void test_Address_entity_address_field() {
		assertEquals(null, address.getAddress());
	}
	
	@Test
	@DisplayName("address entity address2 field")
	void test_Address_entity_address2_field() {
		assertEquals(null, address.getAddress2());
	}
	
	@Test
	@DisplayName("address entity city field")
	void test_Address_entity_city_field() {
		assertEquals(null, address.getCity());
	}
	
	@Test
	@DisplayName("address entity state field")
	void test_Address_entity_state_field() {
		assertEquals(null, address.getState());
	}
	
	@Test
	@DisplayName("address entity postalCode field")
	void test_Address_entity_postalCode_field() {
		assertEquals(null, address.getPostalCode());
	}
	
	@Test
	@DisplayName("address entity country field")
	void test_Address_entity_country_field() {
		assertEquals(null, address.getCountry());
	}

}
