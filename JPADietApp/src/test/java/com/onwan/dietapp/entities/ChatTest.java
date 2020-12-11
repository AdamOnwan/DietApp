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

class ChatTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Chat chat;
	
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
		chat = em.find(Chat.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		chat = null;
		em.close();
	}
	
	@Test
	@DisplayName("chat entity id field")
	void test_Chat_entity_id_field() {
		assertEquals(1, chat.getId());
	}
	
	@Test
	@DisplayName("chat entity message field")
	void test_Chat_entity_message_field() {
		assertEquals("hello cant wait for advice", chat.getMessage());
	}
	
	@Test
	@DisplayName("chat entity messageDate field")
	void test_Chat_entity_messageDate_field() {
		assertEquals("2020-01-16 14:27:33.0", chat.getMessageDate().toString());
	}
}