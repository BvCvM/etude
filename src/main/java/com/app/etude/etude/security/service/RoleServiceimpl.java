package com.app.etude.etude.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import com.app.etude.etude.security.models.Role;
import com.app.etude.etude.security.repository.RoleRepository;
import com.app.etude.etude.services.Roleservices;
@Service
@RequiredArgsConstructor
public class RoleServiceimpl implements Roleservices {
private final RoleRepository repositoryrole;
	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return repositoryrole.save(role);
	}

	@Override
	public List<Role> AllRoles() {
		// TODO Auto-generated method stub
		return repositoryrole.findAll();
	}

	/*@Override
	public void delete(Integer id) {
		repositoryrole.deleteById(id);
		
	}*/

	@Override
	public Role findRoleById(Integer id) {
		
		return repositoryrole.findById(id).get();
	}

}
