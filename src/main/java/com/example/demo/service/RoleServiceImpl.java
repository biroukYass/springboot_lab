package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;

@Service("roleService")
public class RoleServiceImpl implements RoleService{


	@Autowired
    private RoleRepository roleRepository;

	@Override
	public Role findByrole(String role) {
		return roleRepository.findByRole(role);
	}
   

}
