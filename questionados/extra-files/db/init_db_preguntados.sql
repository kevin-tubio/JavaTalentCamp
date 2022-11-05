-- Inicializacion de la tabla categoria
INSERT INTO categoria (descripcion, nombre) VALUES('Historia',			'historia');
INSERT INTO categoria (descripcion, nombre) VALUES('Geografia',			'geografia');
INSERT INTO categoria (descripcion, nombre) VALUES('Entretenimiento',	'Entretenimiento');
INSERT INTO categoria (descripcion, nombre) VALUES('Arte',				'arte');
INSERT INTO categoria (descripcion, nombre) VALUES('Deportes',			'deportes');
INSERT INTO categoria (descripcion, nombre) VALUES('Ciencia',			'ciencia');

-- Inicializacion de la tabla pregunta
-- historia
INSERT INTO pregunta (enunciado, categoria_id) VALUES('De que pais se independizo Eslovenia?', 1);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(true, 'Yugoslavia', 1);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Rusia', 1);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Croacia', 1);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Austria', 1);

INSERT INTO pregunta (enunciado, categoria_id) VALUES('Cual fue el primer pais en aprobar el sufragio femenino?', 1);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(true, 'Nueva Zelanda', 2);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Australia', 2);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Suiza', 2);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Canada', 2);

-- geografia
INSERT INTO pregunta (enunciado, categoria_id) VALUES('Cual es el rio mas caudaloso del mundo?', 2);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(true, 'Amazonas', 3);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Nilo', 3);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Danubio', 3);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Obi', 3);

INSERT INTO pregunta (enunciado, categoria_id) VALUES('Cual es el monte mas alto del mundo?', 2);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(true, 'Everest', 4);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Aconcagua', 4);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Manaslu', 4);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Denali', 4);

-- entretenimiento
INSERT INTO pregunta (enunciado, categoria_id) VALUES('Que banda publico el album Innuendo?', 3);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(true, 'Queen', 5);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Metallica', 5);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Nirvana', 5);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Rush', 5);

INSERT INTO pregunta (enunciado, categoria_id) VALUES('Quien escribio la novela grafica Watchmen?', 3);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(true, 'Alan Moore', 6);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'John Totleben', 6);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Stephen Bissette', 6);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Rick Veitch', 6);

-- arte
INSERT INTO pregunta (enunciado, categoria_id) VALUES('Con que nombre firmaba Van Gogh sus obras?', 4);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(true, 'Vincent', 7);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Vin', 7);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'V.G.', 7);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'V.V.G.', 7);

INSERT INTO pregunta (enunciado, categoria_id) VALUES('Quien pinto el Guernica?', 4);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(true, 'Pablo Picasso', 8);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Henri Matisse', 8);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Pierre-Auguste Renoir', 8);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Claude Monet', 8);

-- deportes
INSERT INTO pregunta (enunciado, categoria_id) VALUES('Cuando se celebro la primera Copa Mundial de Futbol?', 5);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(true, '1930', 9);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, '1934', 9);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, '1928', 9);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, '1932', 9);

INSERT INTO pregunta (enunciado, categoria_id) VALUES('En que deporte se destaco Carl Lewis?', 5);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(true, 'Atletismo', 10);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Judo', 10);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Remo', 10);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Vela', 10);

-- ciencia
INSERT INTO pregunta (enunciado, categoria_id) VALUES('Cual es la velocidad de la luz?', 6);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(true, '300.000.000 km/s', 11);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, '200.000.000 km/s', 11);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, '150.000.000 km/s', 11);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, '350.000.000 km/s', 11);

INSERT INTO pregunta (enunciado, categoria_id) VALUES('Que elemento esta presente en absolutamente todas las moleculas organicas?', 6);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(true, 'Carbono', 12);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Germanio', 12);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Sodio', 12);
INSERT INTO respuesta (es_correcta, texto, pregunta_id) VALUES(false, 'Bromo', 12);
