package com.onwan.dietapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.onwan.dietapp.entities.Address;
import com.onwan.dietapp.entities.Diet;
import com.onwan.dietapp.entities.User;
import com.onwan.dietapp.repositories.AddressRepository;
import com.onwan.dietapp.repositories.DietRepository;
import com.onwan.dietapp.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	AddressRepository addressRepo;

	@Autowired
	DietRepository dietRepo;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User register(User user) {
		if (isUserUnique(user) == false) {
			return null;
		}
		Address registeredAddress = addressRepo.findAll().get(0);
		if (user.getAddress() != null) {
			registeredAddress = user.getAddress();
			registeredAddress = addressRepo.saveAndFlush(registeredAddress);
			user.setAddress(registeredAddress);
		} else if (user.getAddress() == null) {
			user.setAddress(registeredAddress);
		}
		Diet startDiet = dietRepo.findAll().get(0);
		user.setDiet(startDiet);
		String encodedPW = encoder.encode(user.getPassword());
		user.setPassword(encodedPW);
		user.setEnabled(true);
		user.setRole("standard");
		userRepo.saveAndFlush(user);
		return user;
	}

	@Override
	public boolean isUserUnique(User user) {
		User userFound = userRepo.findUserByEmail(user.getEmail());
		if (userFound != null) {
			return false;
		}
		return true;
	}
}
