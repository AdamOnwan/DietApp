package com.onwan.dietapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onwan.dietapp.entities.Chat;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
	
}