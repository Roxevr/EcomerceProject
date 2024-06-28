SET FOREIGN_KEY_CHECKS = 0;
-- Insertando datos en la tabla usuario
INSERT INTO usuario (email, nombre, password, tipo) VALUES
('usuario1@example.com', 'Usuario Uno', 'password1', 0),
('usuario2@example.com', 'Usuario Dos', 'password2', 1);

-- Insertando datos en la tabla carrito
INSERT INTO carrito (fecha_entrega, fecha_salida, usuario_id) VALUES
('2024-06-15', '2024-06-10', 1),
('2024-06-20', '2024-06-15', 2);

-- Insertando datos en la tabla producto
INSERT INTO producto (cantidad, categoria, codigo, descripcion, imagen, nombre, precio) VALUES
(60, 'VIDEOJUEGOS', 'COD001', 'Descripcion del producto 1', 'imagen1.jpg', 'Producto 1', 59.99),
(110, 'VIDEOJUEGOS', 'COD002', 'Descripcion del producto 2', 'imagen2.jpg', 'Producto 2', 39.99),
(100, 'VIDEOJUEGOS', 'COD003', 'Descripcion del producto 3', 'imagen3.jpg', 'Producto 3', 49.99);

-- Insertando datos en la tabla carrito_productos
INSERT INTO carrito_productos (carrito_id_carrito, productos_id_producto) VALUES
(1, 1),
(1, 2),
(2, 3);

SET FOREIGN_KEY_CHECKS = 1; 