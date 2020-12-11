package com.onwan.dietapp.services;

import java.util.List;

import com.onwan.dietapp.entities.User;

public interface UserService {

	List<User> findAll(String username);

	User findUserByEmail(String username);

	User updateUserProfile(String email, User user);

}
