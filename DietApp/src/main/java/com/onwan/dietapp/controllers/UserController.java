package com.onwan.dietapp.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onwan.dietapp.entities.User;
import com.onwan.dietapp.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4212" })
public class UserController {

	@Autowired
	private UserService userSvc;

	@GetMapping("users")
	public List<User> findAll(HttpServletRequest req, HttpServletResponse resp, Principal principal) {
		List<User> users = userSvc.findAll(principal.getName());
		if (users == null) {
			resp.setStatus(404);
		}
		if (users.size() == 0) {
			resp.setStatus(204);
		}
		return users;
	}

	@GetMapping("users/{email}")
	public User getExistingUserByUserEmail(@PathVariable String email, HttpServletRequest req, Principal principal,
			HttpServletResponse resp) {
		User user = null;
		try {
			user = userSvc.findUserByEmail(email);
			if (user == null) {
				resp.setStatus(404);
				return null;
			}
			resp.setStatus(202);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
		}
		return user;
	}

	@PutMapping("users")
	public User replaceExistingUser(@RequestBody User user, HttpServletRequest req, Principal principal,
			HttpServletResponse resp) {
		try {
			user = userSvc.updateUserProfile(principal.getName(), user);
			if (user == null) {
				resp.setStatus(404);
				return null;
			}
			resp.setStatus(202);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(user.getId());
			resp.addHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			return null;
		}
		return user;
	}
}
