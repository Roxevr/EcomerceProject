SET FOREIGN_KEY_CHECKS = 0;

INSERT INTO `producto` (`categoria`, `descripcion`, `imagen`, `nombre`, `precio`, `items_carrito_id`, `items_pedido_id`)
VALUES
("Categoria", 'Descripción del producto 1', 'imagen1.jpg', 'Producto 1', 9.99, NULL, NULL),
("Categoria", 'Descripción del producto 2', 'imagen2.jpg', 'Producto 2', 19.99, NULL, NULL),
("Categoria", 'Descripción del producto 3', 'imagen3.jpg', 'Producto 3', 29.99, NULL, NULL),
("Categoria", 'Descripción del producto 4', 'imagen4.jpg', 'Producto 4', 39.99, NULL, NULL),
("Categoria", 'Descripción del producto 5', 'imagen5.jpg', 'Producto 5', 49.99, NULL, NULL);


INSERT INTO `items_carrito` (`cantidad`, `carrito_id_carrito`)
VALUES
(2, 1),
(3, 2),
(1, 3);

INSERT INTO `carrito` (`fecha_entrega`, `fecha_salida`, `items_carrito_id_item_carrito`, `usuario_id_usuario`)
VALUES
('2024-06-01', '2024-05-25', 1, 1),
('2024-06-02', '2024-05-26', 2, 2),
('2024-06-03', '2024-05-27', 3, 3);



INSERT INTO usuario (nombre, carrito_id_carrito) VALUES 
('Juan Perez', 1),
('Maria Lopez', 2),
('Carlos Garcia', 3);

INSERT INTO pedido (fecha, items_pedido_id_item_pedido, usuario_id_usuario) VALUES 
('2024-05-29', 1, 1),
('2024-05-30', 2, 2),
('2024-05-31', 3, 3);

INSERT INTO items_pedido (cantidad, pedido_id_pedido) VALUES 
(10, 1),
(20, 2),
(30, 3);