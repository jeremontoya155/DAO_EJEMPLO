CREATE DATABASE Base_Nueva;

use Base_Nueva;

CREATE TABLE USUARIOS(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    telefono VARCHAR(45) NOT NULL
    
    
);


INSERT INTO usuarios(nombre, apellido,email,telefono)
VALUES('Jeremias','Montoya','jeremontoya@gmail.com','3516139362');


SELECT * FROM usuarios;