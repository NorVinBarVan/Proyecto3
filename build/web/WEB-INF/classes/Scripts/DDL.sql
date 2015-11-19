CREATE TABLE AGENCIA
(
codigo_agencia INTEGER PRIMARY KEY,
nombre VARCHAR(30),
direccion VARCHAR(20),
departamento VARCHAR(50),
telefono INTEGER
);

CREATE TABLE VENDEDOR
(
codigo_vendedor INTEGER PRIMARY KEY,
nombre VARCHAR(30),
nit INTEGER,
edad INTEGER,
salario INTEGER
);

CREATE TABLE ADMINISTRADOR
(
codigo_adm INTEGER PRIMARY KEY,
nombre VARCHAR(30),
nit INTEGER,
edad INTEGER,
salario INTEGER
);

CREATE TABLE SOLICITUD_DE_COMPRA
(
codigo_solicitud INTEGER PRIMARY KEY,
fecha_de_creacion DATE,
paquete_a_comprar VARCHAR(50),
precio INTEGER,
codigo_adm INTEGER, FOREIGN KEY (codigo_adm) REFERENCES ADMINISTRADOR (codigo_adm),
codigo_vendedor INTEGER, FOREIGN KEY (codigo_vendedor) REFERENCES VENDEDOR (codigo_vendedor)
);

CREATE TABLE PAQUETES_VACACIONALES
(
codigo_paquete INTEGER PRIMARY KEY,
nombre VARCHAR(30),
descripcion VARCHAR(50),
fecha_de_ejecucion DATE,
precio INTEGER,
codigo_adm INTEGER, FOREIGN KEY (codigo_adm) REFERENCES ADMINISTRADOR (codigo_adm)
);


CREATE TABLE ASIGNACION
(
codigo_agencia INTEGER, FOREIGN KEY (codigo_agencia) REFERENCES AGENCIA (codigo_agencia),
codigo_adm INTEGER, FOREIGN KEY (codigo_adm) REFERENCES ADMINISTRADOR (codigo_adm)
);	

CREATE TABLE CONTROL
(
codigo_agencia INTEGER, FOREIGN KEY (codigo_agencia) REFERENCES AGENCIA (codigo_agencia),
codigo_vendedor INTEGER, FOREIGN KEY (codigo_vendedor) REFERENCES VENDEDOR (codigo_vendedor)
);

