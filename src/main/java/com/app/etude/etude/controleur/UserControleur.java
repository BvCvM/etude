package com.app.etude.etude.controleur;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.etude.etude.security.models.User;
import com.app.etude.etude.security.service.UserService;

@RestController
@RequestMapping("/api/User")
public class UserControleur {
	
	private UserService Userservices;
	
	/*@GetMapping("/allUser")
    public List<User> findAllUsers()
	{
		return Userservices.findAllUsers();
	}
	@GetMapping("/{id}")
    public User findUserbyid(@PathVariable Long id)
	{
		return Userservices.findUserbyid(id);
	}*/
	
	
}
