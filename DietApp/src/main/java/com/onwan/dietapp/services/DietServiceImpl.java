package com.onwan.dietapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onwan.dietapp.entities.Diet;
import com.onwan.dietapp.repositories.DietRepository;

@Service
public class DietServiceImpl implements DietService {
	
	@Autowired
	private DietRepository dietRepo;
	
	@Override
	public List<Diet> allDiets() {
		return dietRepo.findAll();
	}
	
	@Override
	public List<Diet> showDietByEmail(String email) {
		return dietRepo.findByUsersEmail(email);
	}
	
	@Override
	public Diet createDiet(Diet diet) {
		dietRepo.saveAndFlush(diet);
		return diet;
	}
	
	@Override
	public Diet updateDiet(Diet diet, int dietId) {
		Diet existing = null;
		Optional<Diet> op = dietRepo.findById(dietId);
		if(op.isPresent()) {
			existing = op.get();
			existing.setName(diet.getName());
			existing.setDescription(diet.getDescription());
			existing.setPurpose(diet.getPurpose());
			dietRepo.saveAndFlush(existing);
		} else {
			return null;
		}
		return existing;
	}
}
