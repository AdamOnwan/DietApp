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

class EquipmentTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Equipment equipment;
	
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
		equipment = em.find(Equipment.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		equipment = null;
		em.close();
	}

	@Test
	@DisplayName("equipment entity id field")
	void test_Equipment_entity_id_field() {
		assertEquals(1, equipment.getId());
	}
	
	@Test
	@DisplayName("equipment entity name field")
	void test_Equipment_entity_name_field() {
		assertEquals("frying pan", equipment.getName());
	}
	
	@Test
	@DisplayName("equipment entity description field")
	void test_Equipment_entity_description_field() {
		assertEquals("pan used for frying", equipment.getDescription());
	}
}
