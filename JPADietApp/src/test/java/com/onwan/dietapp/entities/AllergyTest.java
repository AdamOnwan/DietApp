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

class AllergyTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Allergy allergy;
	
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
		allergy = em.find(Allergy.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		allergy = null;
		em.close();
	}
	
	@Test
	@DisplayName("allergy entity id field")
	void test_Allergy_entity_id_field() {
		assertEquals(1, allergy.getId());
	}
	
	@Test
	@DisplayName("allergy entity name field")
	void test_Allergy_entity_name_field() {
		assertEquals("None", allergy.getName());
	}
	
	@Test
	@DisplayName("allergy entity description field")
	void test_Allergy_entity_description_field() {
		assertEquals(null, allergy.getDescription());
	}
}