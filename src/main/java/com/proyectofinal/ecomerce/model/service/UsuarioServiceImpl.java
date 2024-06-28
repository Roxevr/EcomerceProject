package com.proyectofinal.ecomerce.model.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyectofinal.ecomerce.model.Role;
import com.proyectofinal.ecomerce.model.User;
import com.proyectofinal.ecomerce.model.dao.RoleDao;
import com.proyectofinal.ecomerce.model.dao.UsuarioDao;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
    private UsuarioDao usuarioDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
    public User guardarUsuario(User user) {
		Optional<Role> optionalRoleUser = roleDao.findByName("USER");
		List<Role> roles = new ArrayList<Role>();
		
		optionalRoleUser.ifPresent(roles::add);
		
		if(user.isAdmin()) {
			Optional<Role> optionalRoleAdmin = roleDao.findByName("ADMIN");
			optionalRoleAdmin.ifPresent(roles::add);
		}
		
		user.setRoles(roles);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
        return usuarioDao.save(user);
    }

	@Override
	@Transactional(readOnly = true)
    public User obtenerUsuarioPorEmail(String email) {
        return usuarioDao.findByEmail(email).orElse(null);
    }
	
	@Override
	@Transactional(readOnly = true)
    public User obtenerUsuarioPorId(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }
}
