CREATE DATABASE credito;
USE credito;

CREATE TABLE credito(
	id INT PRIMARY KEY AUTO_INCREMENT,
    tipo_documento VARCHAR(20) NOT NULL,
    documento VARCHAR(12) NOT NULL UNIQUE,
    nombre_completo VARCHAR(50) NOT NULL,
    estado_credito boolean NOT NULL,
    valor_credito INT NOT NULL 
); 
select * from credito;