CREATE TABLE Cliente (
	nombre_cliente string,
	id_cliente integer PRIMARY KEY AUTOINCREMENT,
	CI string,
	email string
);

CREATE TABLE Factura (
	id_cliente integer,
	id_factura integer PRIMARY KEY AUTOINCREMENT,
	fecha datetime,
	id_proveedor integer
);

CREATE TABLE Detalle (
	id_detalle integer PRIMARY KEY AUTOINCREMENT,
	id_factura integer,
	cantidad string,
	precio integer
);

CREATE TABLE Proveedor (
	id_proveedor integer PRIMARY KEY AUTOINCREMENT,
	nombre_proveedor string
);

