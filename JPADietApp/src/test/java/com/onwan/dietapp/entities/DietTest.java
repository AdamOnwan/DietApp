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

class DietTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Diet diet;
	
	@BeforeAll
	static void setUpBeforeClass() {
		emf = Persistence.createEntityManagerFactory("DietApp");
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		emf.close();
	}
	
	@BeforeEach
	void setUp() {
		em = emf.createEntityManager();
		diet = em.find(Diet.class, 1);
	}
	
	@AfterEach
	void tearDown() {
		diet = null;
		em.close();
	}

	@Test
	@DisplayName("diet entity id field")
	void test_Diet_entity_id_field() {
		assertEquals(1, diet.getId());
	}
	
	@Test
	@DisplayName("diet entity name field")
	void test_Diet_entity_name_field() {
		assertEquals("No Diet", diet.getName());
	}
	
	@Test
	@DisplayName("diet entity purpose field")
	void test_Diet_entity_purpose_field() {
		assertEquals(null, diet.getPurpose());
	}
	
	@Test
	@DisplayName("diet entity description field")
	void test_Diet_entity_description_field() {
		assertEquals(null, diet.getDescription());
	}
}
