CREATE DATABASE parcial1;
USE parcial1;

CREATE TABLE rol(
	id INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(50) NOT NULL
);

CREATE TABLE persona(
	id INT PRIMARY KEY AUTO_INCREMENT,
    tipo_documento VARCHAR(20) NOT NULL,
    documento VARCHAR(12) NOT NULL UNIQUE,
    nombre_completo VARCHAR(50) NOT NULL,
    correo VARCHAR(50) NOT NULL UNIQUE,
    rol_id INT NOT NULL,
	CONSTRAINT fk_persona_rol_id_rol_id FOREIGN KEY (rol_id) REFERENCES rol(id)
);

CREATE TABLE sala(
	id INT PRIMARY KEY AUTO_INCREMENT,
    pasillo INT UNIQUE NOT NULL,
    categoria VARCHAR(50) NOT NULL
);

CREATE TABLE libro(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(80) UNIQUE NOT NULL,
    sala_id INT NOT NULL,
    prestamo_persona_id INT UNIQUE,
	CONSTRAINT fk_sala_id_sala_id FOREIGN KEY (sala_id) REFERENCES sala(id),
	CONSTRAINT fk_prestamo_persona_id_persona_id FOREIGN KEY (prestamo_persona_id) REFERENCES persona(id)
);

DROP TABLE libro;

INSERT INTO rol(tipo) VALUES
('Administrador'),
('Visitante');

SELECT * FROM rol;

INSERT INTO persona(tipo_documento, documento, nombre_completo, correo, rol_id) VALUES
('CC','3473287432','Jesus Ariel','arielito@gmail.com', 1),
('TI', '7890123', 'Carlos Suarez', 'carlos@gmail.com', 2),
('CC', '1234567', 'Juan Bautista', 'juan.bautista@gmail.com',2);

SELECT * FROM persona;

INSERT INTO sala(pasillo, categoria) VALUES
(10,'accion'),
(20,'terror'),
(30,'ficcion');

SELECT * FROM sala;

INSERT INTO libro(nombre, sala_id, prestamo_persona_id) VALUES
('Viaje al centro de la tierra', 3, null),
('El conjuro', 2, null),
('Spiderman', 2, 2);
