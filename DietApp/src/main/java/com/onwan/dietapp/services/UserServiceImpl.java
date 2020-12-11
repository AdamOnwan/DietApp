package com.onwan.dietapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onwan.dietapp.entities.Address;
import com.onwan.dietapp.entities.User;
import com.onwan.dietapp.repositories.AddressRepository;
import com.onwan.dietapp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	private AddressRepository addressRepo;

	@Override
	public List<User> findAll(String email) {
		User user = userRepo.findUserByEmail(email);
		if (user.getRole().equals("admin")) {
			return userRepo.findAll();
		}
		return null;
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepo.findUserByEmail(email);
	}

	@Override
	public User updateUserProfile(String email, User user) {
		User userPrincipal = userRepo.findUserByEmail(email);
		if (userPrincipal.getId() == user.getId()) {
			Optional<User> userOpt = userRepo.findById(user.getId());
			if (userOpt.isPresent()) {
				User managedUser = userOpt.get();
				if (user.getAddress() != null) {
					Optional<Address> addressOpt = addressRepo.findById(user.getAddress().getId());
					if (addressOpt.isPresent()) {
						Address managedAddress = addressOpt.get();
						if (user.getAddress().getAddress() != null) {
							managedAddress.setAddress(user.getAddress().getAddress());
						}
						if (user.getAddress().getAddress2() != null) {
							managedAddress.setAddress2(user.getAddress().getAddress2());
						}
						if (user.getAddress().getCity() != null) {
							managedAddress.setCity(user.getAddress().getCity());
						}
						if (user.getAddress().getState() != null) {
							managedAddress.setState(user.getAddress().getState());
						}
						if (user.getAddress().getPostalCode() != null) {
							managedAddress.setPostalCode(user.getAddress().getPostalCode());
						}
						if (user.getAddress().getCountry() != null) {
							managedAddress.setCountry(user.getAddress().getCountry());
						}
						addressRepo.saveAndFlush(managedAddress);
					}
				}
				managedUser.setFirstName(user.getFirstName());
				managedUser.setLastName(user.getLastName());
				managedUser.setEmail(user.getEmail());
				managedUser.setPassword(user.getPassword());
				managedUser.setPhone(user.getPhone());
				managedUser.setImageUrl(user.getImageUrl());
				managedUser.setHeight(user.getHeight());
				managedUser.setWeight(user.getWeight());
				managedUser.setDescription(user.getDescription());
				userRepo.saveAndFlush(managedUser);
				return managedUser;
			}
		}
		return null;
	}
}