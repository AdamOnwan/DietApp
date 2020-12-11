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

class RecipeTest {
	
	static private EntityManagerFactory emf;
	private EntityManager em;
	private Recipe recipe;
	
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
		recipe = em.find(Recipe.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		recipe = null;
		em.close();
	}
	
	@Test
	@DisplayName("recipe entity id field")
	void test_Recipe_entity_id_field() {
		assertEquals(1, recipe.getId());
	}
	
	@Test
	@DisplayName("recipe entity name field")
	void test_Recipe_entity_name_field() {
		assertEquals("Salad", recipe.getName());
	}
	
	@Test
	@DisplayName("recipe entity description field")
	void test_Recipe_entity_description_field() {
		assertEquals("vegetarian meal", recipe.getDescription());
	}
	
	@Test
	@DisplayName("recipe entity cookTime field")
	void test_Recipe_entity_cookTime_field() {
		assertEquals(0, recipe.getCookTime());
	}
	
	@Test
	@DisplayName("recipe entity prepTime field")
	void test_Recipe_entity_prepTime_field() {
		assertEquals(10, recipe.getPrepTime());
	}
	
	@Test
	@DisplayName("recipe entity imageUrl field")
	void test_entity_imageUrl_field() {
		assertEquals(null, recipe.getImageUrl());
	}
	
	@Test
	@DisplayName("recipe entity imageUrl2 field")
	void test_entity_imageUrl2_field() {
		assertEquals(null, recipe.getImageUrl2());
	}
	
	@Test
	@DisplayName("recipe entity imageUrl3 field")
	void test_entity_imageUrl3_field() {
		assertEquals(null, recipe.getImageUrl3());
	}
}
