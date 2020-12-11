package com.onwan.dietapp.services;

import com.onwan.dietapp.entities.User;

public interface AuthService {

	User register(User user);

	boolean isUserUnique(User user);

}
