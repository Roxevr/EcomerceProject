package com.proyectofinal.ecomerce.model.service;

import java.util.Optional;

import com.proyectofinal.ecomerce.model.User;

public interface UsuarioService {

	User guardarUsuario(User usuario);

	User obtenerUsuarioPorEmail(String email);

	User obtenerUsuarioPorId(Long id);

}
