package com.onwan.dietapp.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;
	
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
		user = em.find(User.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		user = null;
		em.close();
	}
	
	@Test
	@DisplayName("user entity id field")
	void test_User_entity_id_field() {
	assertEquals(1, user.getId());
	}
	
	@Test
	@DisplayName("user entity firstName field")
	void test_User_entity_firstName_field() {
		assertEquals("Adam", user.getFirstName());
	}
	
	@Test
	@DisplayName("user entity lastName field")
	void test_User_entity_lastName_field() {
		assertEquals("Adam", user.getLastName());
	}
	
	@Test
	@DisplayName("user entity email field")
	void test_User_entity_email_field() {
		assertEquals("adam@adam.com", user.getEmail());
		}
	
	@Test
	@DisplayName("user entity password field")
	void test_User_entity_password_field() {
		assertEquals("$2y$12$", user.getPassword().toString().substring(0, 7));
	}
	
	@Test
	@DisplayName("user entity phone field")
	void test_User_entity_phone_field() {
		assertEquals("111-111-1111", user.getPhone());
	}
	
	@Test
	@DisplayName("user entity enabled field")
	void test_User_entity_enabled_field() {
		assertTrue(user.isEnabled() == true);
	}
	
	@Test
	@DisplayName("user entity imageUrl field")
	void test_User_entity_imageUrl_field() {
		assertEquals(null, user.getImageUrl());
	}
	
	@Test
	@DisplayName("user entity height field")
	void test_User_entity_height_field() {
		assertEquals(64, user.getHeight());
	}
	
	@Test
	@DisplayName("user entity weight field")
	void test_User_entity_weight_field() {
		assertEquals(140, user.getWeight());
	}
	
	@Test
	@DisplayName("user entity description field")
	void test_User_entity_description_field() {
		assertEquals("adam is adam", user.getDescription());
	}
	
	@Test
	@DisplayName("user to food field")
	void test_User_to_Food_field() {
		assertEquals("bread", user.getFoods().get(0).getName());
	}
	@Test
	@DisplayName("userEquipment relationship mapping")
	void test_User_to_Equipment_field() {
		assertEquals("frying pan", user.getEquipmentList().get(0).getName());
	}
}
