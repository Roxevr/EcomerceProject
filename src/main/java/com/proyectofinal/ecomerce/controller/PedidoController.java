package com.proyectofinal.ecomerce.controller;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyectofinal.ecomerce.model.Carrito;
import com.proyectofinal.ecomerce.model.ItemCarrito;
import com.proyectofinal.ecomerce.model.ItemPedido;
import com.proyectofinal.ecomerce.model.Pedido;
import com.proyectofinal.ecomerce.model.Product;
import com.proyectofinal.ecomerce.model.User;
import com.proyectofinal.ecomerce.model.service.CarritoService;
import com.proyectofinal.ecomerce.model.service.PedidoService;
import com.proyectofinal.ecomerce.model.service.ProductoService;
import com.proyectofinal.ecomerce.model.service.UsuarioService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
    private CarritoService carritoService;
	
	@Autowired
    private PedidoService pedidoService;;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("")
    public String getPedidos(Model model,
    		@RequestParam(name = "email", required = false) String email) {
    	//Usuario usuario = usuarioService.obtenerUsuarioPorEmail(email);
    	User usuario = usuarioService.obtenerUsuarioPorId(1L);
    	List<Pedido> pedidos =  pedidoService.obtenerPedidosPorUsuario(usuario);
    	
    	
    	model.addAttribute("pedidos", pedidos);
    	return "/pedidos/pedido";
    }

    @PostMapping("/agregar")
    public String agregarPedido(
    		@RequestParam(name = "email", required = false) String email,
    		@RequestParam(name = "carrito", required = false) Carrito carrito) {
    	
        //Usuario usuario = usuarioService.obtenerUsuarioPorEmail(email);
        User user = usuarioService.obtenerUsuarioPorId(1L); 
        carrito = carritoService.obtenerCarritoPorUsuario(user);
        
        Set<ItemCarrito> items = carrito.getItemsCarrito();
        Pedido pedido = new Pedido();
        
        pedido.setUser(user);
        pedido.setFechaCreacion(LocalDate.now());
        
        for (ItemCarrito itemCarrito : items) {
			pedido.addItem(new ItemPedido(itemCarrito.getAmount(), itemCarrito.getProduct()));
		}
        pedidoService.guardarPedido(pedido);
       
        return "redirect:/pedido";
    }
}
