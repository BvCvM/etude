package com.app.etude.etude.controleur;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.etude.etude.security.models.Role;
import com.app.etude.etude.services.Roleservices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/role")
@RequiredArgsConstructor
public class RoleControleur{
    private final Roleservices roleservices;
	
	@GetMapping("/allroles")
    public List<Role> AllRoles()
	{
		return roleservices.AllRoles();
	}
	@GetMapping("/{id}")
    public Role findRolebyid(@PathVariable Integer id)
	{
		return roleservices.findRoleById(id);
	}
	@PostMapping("/save")
	public Role AddRole(@RequestBody Role role) {
		return roleservices.addRole(role);
	}

}
