-- REGISTROS TABLA CHATS
INSERT INTO CHAT_MESSAGE (id) VALUES (1);
INSERT INTO CHAT_MESSAGE (id) VALUES (2);

------ REGISTROS TABLA FICHEROS
--INSERT INTO FICHERO (nombre, tamano) VALUES ('hola don pepito', 10.5);
--INSERT INTO FICHERO (nombre, tamano) VALUES ('hola don jose', 6.0);

-- REGISTROS TABLA SALAS
INSERT INTO SALA (nombre, aforo) VALUES ('Sala 1', 4);
INSERT INTO SALA (nombre, aforo) VALUES ('Sala 2', 6);
INSERT INTO SALA (nombre, aforo) VALUES ('Sala 3', 8);
INSERT INTO SALA (nombre, aforo) VALUES ('Sala 4', 15);


---- REGISTROS TABLA USUARIOS
INSERT INTO USUARIO (nombre) VALUES ('Pedro');
INSERT INTO USUARIO (nombre) VALUES ('Chema');
INSERT INTO USUARIO (nombre) VALUES ('Manu');
INSERT INTO USUARIO (nombre) VALUES ('Pedro1');
INSERT INTO USUARIO (nombre) VALUES ('Chema1');
INSERT INTO USUARIO (nombre) VALUES ('Manu1');

---- REGISTROS TABLA EVENTOS
INSERT INTO EVENTO (nombre, sala_id) VALUES ('Uno', 1);
INSERT INTO EVENTO (nombre, sala_id) VALUES ('Dos', 2);
INSERT INTO EVENTO (nombre, sala_id) VALUES ('Tres', 2);
INSERT INTO EVENTO (nombre, sala_id) VALUES ('Cuatro', 1);
INSERT INTO EVENTO (nombre, sala_id) VALUES ('Cinco', 3);
INSERT INTO EVENTO (nombre, sala_id) VALUES ('Seis', 4);

-- REGISTROS TABLA FICHEROS
INSERT INTO FICHERO (nombre, tamano, ruta, evento_id) VALUES ('border collie.docx', 12, '\documentos\border collie.docx', 1);
INSERT INTO FICHERO (nombre, tamano, ruta, evento_id) VALUES ('clima en España y en Europa.pdf', 837, '\documentos\clima en España y en Europa.pdf', 1);
INSERT INTO FICHERO (nombre, tamano, ruta, evento_id) VALUES ('El Cambio Climatico.pdf', 3794, '\documentos\El Cambio Climatico.pdf', 2);
INSERT INTO FICHERO (nombre, tamano, ruta, evento_id) VALUES ('EL CLIMA.pptx', 79, '\documentos\archivos\EL CLIMA.pptx', 2);

-- REGISTROS TABLA EVENTO_LISTA_USUARIOS
INSERT INTO EVENTO_LISTA_USUARIOS (evento_id, usuario_id) VALUES (1, 1);
INSERT INTO EVENTO_LISTA_USUARIOS (evento_id, usuario_id) VALUES (1, 2);
INSERT INTO EVENTO_LISTA_USUARIOS (evento_id, usuario_id) VALUES (1, 3);
INSERT INTO EVENTO_LISTA_USUARIOS (evento_id, usuario_id) VALUES (2, 1);
INSERT INTO EVENTO_LISTA_USUARIOS (evento_id, usuario_id) VALUES (2, 3);
INSERT INTO EVENTO_LISTA_USUARIOS (evento_id, usuario_id) VALUES (1, 4);
INSERT INTO EVENTO_LISTA_USUARIOS (evento_id, usuario_id) VALUES (2, 6);



-- REGISTROS TABLA MEDIOS_TECNICOS
INSERT INTO MEDIO_TECNICO (nombre) VALUES ('Presentacion');
INSERT INTO MEDIO_TECNICO (nombre) VALUES ('Megafonía');
INSERT INTO MEDIO_TECNICO (nombre) VALUES ('Grabación');
INSERT INTO MEDIO_TECNICO (nombre) VALUES ('Emisión en streaming');
INSERT INTO MEDIO_TECNICO (nombre) VALUES ('Wifi');

-- REGISTROS TABLA HORARIOS
INSERT INTO HORARIO (hinicio, hfinal) VALUES ('10:00:00', '12:00:00');
INSERT INTO HORARIO (hinicio, hfinal) VALUES ('11:00:00', '16:30:00');
INSERT INTO HORARIO (hinicio, hfinal) VALUES ('12:00:00', '14:00:00');

INSERT INTO SALA_LISTA_MEDIOS_TECNICOS (sala_id, medio_id) VALUES (1, 1);
INSERT INTO SALA_LISTA_MEDIOS_TECNICOS (sala_id, medio_id) VALUES (1, 2);
INSERT INTO SALA_LISTA_MEDIOS_TECNICOS (sala_id, medio_id) VALUES (2, 1);
INSERT INTO SALA_LISTA_MEDIOS_TECNICOS (sala_id, medio_id) VALUES (2, 5);
INSERT INTO SALA_LISTA_MEDIOS_TECNICOS (sala_id, medio_id) VALUES (3, 2);
INSERT INTO SALA_LISTA_MEDIOS_TECNICOS (sala_id, medio_id) VALUES (3, 3);
INSERT INTO SALA_LISTA_MEDIOS_TECNICOS (sala_id, medio_id) VALUES (3, 4);
INSERT INTO SALA_LISTA_MEDIOS_TECNICOS (sala_id, medio_id) VALUES (4, 1);
INSERT INTO SALA_LISTA_MEDIOS_TECNICOS (sala_id, medio_id) VALUES (4, 2);
INSERT INTO SALA_LISTA_MEDIOS_TECNICOS (sala_id, medio_id) VALUES (4, 3);
INSERT INTO SALA_LISTA_MEDIOS_TECNICOS (sala_id, medio_id) VALUES (4, 4);
INSERT INTO SALA_LISTA_MEDIOS_TECNICOS (sala_id, medio_id) VALUES (4, 5);

--INSERT INTO SALA_LISTA_EVENTOS (sala_id, evento_id) VALUES (1, 1);
--INSERT INTO SALA_LISTA_EVENTOS (sala_id, evento_id) VALUES (1, 2);
--INSERT INTO SALA_LISTA_EVENTOS (sala_id, evento_id) VALUES (2, 2);
--INSERT INTO SALA_LISTA_EVENTOS (sala_id, evento_id) VALUES (3, 1);
--INSERT INTO SALA_LISTA_EVENTOS (sala_id, evento_id) VALUES (4, 1);
--INSERT INTO SALA_LISTA_EVENTOS (sala_id, evento_id) VALUES (4, 2);