drop database if exists pedidos;
create database pedidos;

use pedidos;

create table producto (
	idProducto int primary key AUTO_INCREMENT,
    nombre varchar(250),
    descripcion varchar(250),
    precio double,
    imagen varchar(250)
);

create table cliente (
	idCliente int primary key AUTO_INCREMENT,
    dni varchar(12),
    nombre varchar(250)
);

create table pedido (
	idPedido int primary key AUTO_INCREMENT,
    idCliente int, 
    fecha timestamp default current_timestamp,
    foreign key (idCliente) references cliente(idCliente)
);

create table lineaPedido (
	idLineaPedido int primary key AUTO_INCREMENT,
    idPedido int,
    idProducto int,
    cantidad int,
    foreign key (idProducto) references producto(idProducto),
    foreign key (idPedido) references pedido(idPedido)
);

insert into producto(nombre, descripcion, precio, imagen)
values 	('camiseta', 'Camiseta de manga corta.', 15.5, 'img/camiseta.jpg'),
		('pantalon', 'Pantalon vaquero', 30, 'img/pantalon.jpg'),
		('chaqueta', 'Chaqueta de cuero.',  47.75, 'img/chaqueta.jpg'),
		('zapatos', 'Zapatos negros', 100, 'img/zapatos.jpg');

insert into cliente(dni, nombre) 
values 	('11111111A','Daniel'),
		('22222222B','Lucia'),
		('33333333C','Beatriz');

insert into pedido(idCliente, fecha)
values 	(1,'2020-11-05 12:24:37'),
		(2,'2022-10-20 08:34:11');

insert into lineaPedido(idPedido, idProducto, cantidad)
values 	(1, 1, 3),
		(1, 2, 6),
		(2, 2, 10),
		(2, 3, 5),
		(2, 4, 5);


