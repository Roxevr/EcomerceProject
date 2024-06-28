package com.proyectofinal.ecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinal.ecomerce.model.User;
import com.proyectofinal.ecomerce.model.service.UsuarioService;

@Controller()
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
    private UsuarioService usuarioService;
	
	@GetMapping("/form")
    public String crearUsuarioForm(@RequestBody User usuario) {
    	return "";
    }
	
    @PostMapping("/form")
    public String crearUsuario(@RequestBody User usuario) {
    	usuarioService.guardarUsuario(usuario);
    	return "";
    }

    @GetMapping("/{email}")
    public String obtenerUsuarioPorEmail(@PathVariable String email) {
    	usuarioService.obtenerUsuarioPorEmail(email);
        return "";
    }
}
