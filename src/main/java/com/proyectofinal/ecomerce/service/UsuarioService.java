package com.proyectofinal.ecomerce.service;

import com.proyectofinal.ecomerce.model.Usuario;

public interface UsuarioService {

	Usuario guardarUsuario(Usuario usuario);

	Usuario obtenerUsuarioPorEmail(String email);

}
