package com.app.etude.etude.services;

import java.util.List;

import com.app.etude.etude.security.models.Role;

public interface Roleservices {
	Role addRole(Role role);
	List<Role> AllRoles();
	Role findRoleById(Integer id);
}
