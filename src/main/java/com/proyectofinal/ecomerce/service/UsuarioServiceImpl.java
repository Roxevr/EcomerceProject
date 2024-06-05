package com.proyectofinal.ecomerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.ecomerce.dao.UsuarioDao;
import com.proyectofinal.ecomerce.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
    private UsuarioDao usuarioDao;
	
	@Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

	@Override
    public Usuario obtenerUsuarioPorEmail(String email) {
        return usuarioDao.findByEmail(email);
    }
}
