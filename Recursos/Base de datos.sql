/*DROP DATABASE aeb;*/
CREATE DATABASE aeb;
USE aeb;

CREATE TABLE actividad(
id_actividad INT(11) PRIMARY KEY AUTO_INCREMENT,
actividad VARCHAR(150) NOT NULL
);

CREATE TABLE estudiante(
registro_academico INT (9) PRIMARY KEY NOT NULL,
dpi VARCHAR(50) NOT NULL,
nombre VARCHAR(50) NOT NULL,
unidad_academica VARCHAR(50) NOT NULL,
carrera VARCHAR(150) NOT NULL
);

CREATE TABLE control(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
fecha DATE NOT NULL,
lugar VARCHAR(150) NOT NULL,
hora_inicio VARCHAR(50) NULL,
hora_fin VARCHAR(50) NULL,
horas FLOAT NOT NULL,
registro_academico INT(9) NOT NULL,
id_actividad INT(11) NOT NULL,
FOREIGN KEY (registro_academico) REFERENCES estudiante (registro_academico),
FOREIGN KEY (id_actividad) REFERENCES actividad (id_actividad)
);

INSERT INTO actividad VALUES(1, 'Registro DB');

