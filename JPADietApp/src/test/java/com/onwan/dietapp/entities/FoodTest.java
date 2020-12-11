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

class FoodTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Food food;
	
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
		food = em.find(Food.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		food = null;
		em.close();
	}

	@Test
	@DisplayName("food entity id field")
	void test_Food_entity_id_field() {
		assertEquals(1, food.getId());
	}
	
	@Test
	@DisplayName("food entity name field")
	void test_Food_entity_name_field() {
		assertEquals("bread", food.getName());
	}
	
	@Test
	@DisplayName("food entity description field")
	void test_Food_entity_description_field() {
		assertEquals("made from dough and flour", food.getDescription());
	}
	
	@Test
	@DisplayName("food entity portionSize field")
	void test_Food_entity_portionSize_field() {
		assertEquals(51.0, food.getPortionSize());
	}
	
	@Test
	@DisplayName("food entity portionType field")
	void test_Food_entity_portionType_field() {
	assertEquals("gram", food.getPortionType());
	}
	
	@Test
	@DisplayName("food entity calorie field")
	void test_Food_entity_calorie_field() {
		assertEquals(54, food.getCalorie());
	}
	
	@Test
	@DisplayName("food entity fat field")
	void test_Food_entity_fat_field() {
		assertEquals(0.5, food.getFat());
	}
	
	@Test
	@DisplayName("food entity cholesterol field")
	void test_Food_entity_cholestrol_field() {
		assertEquals(0, food.getCholestrol());
	}
	
	@Test
	@DisplayName("food entity sodium field")
	void test_Food_entity_sodium_field() {
		assertEquals(97.0, food.getSodium());
	}
	
	@Test
	@DisplayName("food entity carbohydrate field")
	void test_Food_entity_carbohydrate_field() {
		assertEquals(11.2, food.getCarbohydrate());
	}
	
	@Test
	@DisplayName("food entity fiber field")
	void test_Food_entity_fiber_field() {
		assertEquals(2.4, food.getFiber());
	}
	
	@Test
	@DisplayName("food entity sugar field")
	void test_Food_entity_sugar_field() {
		assertEquals(1.0, food.getSugar());
	}
	
	@Test
	@DisplayName("food entity protein field")
	void test_Food_entity_protein_field() {
		assertEquals(2.0, food.getProtein());
	}
}