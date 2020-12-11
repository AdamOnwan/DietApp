package com.onwan.dietapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onwan.dietapp.entities.Allergy;
import com.onwan.dietapp.entities.User;
import com.onwan.dietapp.repositories.AllergyRepository;
import com.onwan.dietapp.repositories.UserRepository;

@Service
public class AllergyServiceImpl implements AllergyService {
	
	@Autowired
	private AllergyRepository allergyRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<Allergy> allAllergies() {
		return allergyRepo.findAll();
	}
	
	@Override
	public List<Allergy> showAllergiesByEmail(String email) {
		User user = userRepo.findAllergyByEmail(email);
		List<Allergy> allergy;
		allergy = allergyRepo.findByUsersId(user.getId());
		return allergy;
	}
	
	@Override
	public Allergy createAllergy(Allergy allergy) {
		allergyRepo.saveAndFlush(allergy);
		return allergy;
	}
	
	@Override
	public Allergy updateAllery(Allergy allergy, int allergyId) {
		Allergy existing = null;
		Optional<Allergy> op = allergyRepo.findById(allergyId);
		if(op.isPresent()) {
			existing = op.get();
			existing.setName(allergy.getName());
			existing.setDescription(allergy.getDescription());
			allergyRepo.saveAndFlush(existing);
		} else {
			return null;
		}
		return existing;
	}
}
