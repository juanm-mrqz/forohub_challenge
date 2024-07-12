INSERT INTO profiles (name) VALUES ("ADMIN");
INSERT INTO profiles (name) VALUES ("MOD");
INSERT INTO profiles (name) VALUES ("USER");

INSERT INTO users (login, password, email)
VALUES ('admin', '$2a$10$8YQBNVNsRCjZ482tVIeQR..i1A95kdPVRX9uGVyd5oLdBvY5TQWE2', 'admin@example.com') ;

INSERT INTO users_profiles(user_id, profile_id) VALUES(1, 1);

INSERT INTO courses(category, name) VALUES ('PROGRAMACION', 'Introduccion a Java');
INSERT INTO courses(category, name) VALUES ('PROGRAMACION', 'Introduccion a Python'); 
INSERT INTO courses(category, name) VALUES ('PROGRAMACION', 'Java Intermedio'); 
INSERT INTO courses(category, name) VALUES ('PROGRAMACION', 'Desarrollo Backend con Java y Spring Boot'); 
INSERT INTO courses(category, name) VALUES ('ELECTRONICA', 'Principios de electronica analogica'); 
INSERT INTO courses(category, name) VALUES ('ELECTRONICA', 'Principios de electronicao digital'); 
INSERT INTO courses(category, name) VALUES ('CS', 'Introduccion Ciencias de la computacion'); 
INSERT INTO courses(category, name) VALUES ('MATEMATICA', 'Algebra Lineal'); 
INSERT INTO courses(category, name) VALUES ('MATEMATICA', 'Geometria en el espacio'); 
INSERT INTO courses(category, name) VALUES ('LOGICA', 'Introduccion a la logica de programacion'); 
INSERT INTO courses(category, name) VALUES ('LOGICA', 'Logica de programacion : Primeros pasos con C'); 