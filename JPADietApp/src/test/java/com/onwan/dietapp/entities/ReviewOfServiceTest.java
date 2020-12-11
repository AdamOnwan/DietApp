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

class ReviewOfServiceTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private ReviewOfService reviewOfService;
	
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
		reviewOfService = em.find(ReviewOfService.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		em.close();
		reviewOfService = null;
	}

	@Test
	@DisplayName("reviewOfService entity id field")
	void test_reviewOfService_entity_id_field() {
		assertEquals(1, reviewOfService.getId());
	}
	
	@Test
	@DisplayName("reviewOfService entity rating field")
	void test_reviewOfService_entity_rating_field() {
		assertEquals(5.0, reviewOfService.getRating());
	}
	
	@Test
	@DisplayName("reviewOfService entity review field")
	void test_reviewOfService_entity_review_field() {
		assertEquals("amanda gives great advice", reviewOfService.getReview());
	}
	
	@Test
	@DisplayName("reviewOfService entity reviewDate field")
	void test_reviewOfService_entity_reviewDate_field() {
		assertTrue(reviewOfService.getReviewDate().toString().contains("2020-01-31 00:00:00.0"));
	}
}
