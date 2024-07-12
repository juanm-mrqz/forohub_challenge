<h1 align="center"> Forohub - Alura ONE </h1>

## :white_check_mark: Tecnologías utilizadas

- `Java 17`
- `Maven`
-  `Spring-Boot : 3.2.5`
    - `Spring Data Jpa`
    - `Lombok`
    - `Spring Boot Dev-Tools`
    - `MySql Driver`
    - `Spring Security`
    - `Json Web Token`
    - `Spring Web`
    - `Flyway`
- `IntelliJ IDEA`

<h2>Modelado del proyecto</h2>
<img src="https://github.com/juanm-mrqz/forohub_challenge/blob/main/assets/images/db-schema.png" alt="Esquema de base de datos">

- <h4>Inicializacion de Base de datos</h2>
Antes de probar la app, hay que configurar el archivo `application properties` para poder utilizar en el entorno local de MySQL con una base
de datos propia. Se deben reemplazar los campos:<br/>
    - `spring.datasource.url=jdbc:mysql://localhost:3306/<nombre_db>` <br/>
    - `spring.datasource.username=<usuario>` <br/>
    - `spring.datasource.password=<contraseña>` <br/>
<img src="https://github.com/juanm-mrqz/forohub_challenge/blob/main/assets/images/db-config.png" alt="configuracion de base de datos">

- <h4>Inicializacion de datos</h4>
Para poder utilizar el sistema sin mas configuracion, ya hay presente cargados datos inicializados en el sistema, como cursos, roles y 
un usuario administrador (user: admin, pass: admin)
<img src="https://github.com/juanm-mrqz/forohub_challenge/blob/main/assets/images/db-init_data.png" alt="Inicializacion de datos">

- <h4>Autenticacion de usuario</h4>
Para poder realizar cualquier consulta a la API, primero debe registrarse el usuario. En primera instancia se puede utilizar el admin proporcionado por defecto 
o registrar otro usuario y usar dichas credenciales (siguiente paso) 

<img src="https://github.com/juanm-mrqz/forohub_challenge/blob/main/assets/images/login-request.png" alt="Login de usuario">
<img src="https://github.com/juanm-mrqz/forohub_challenge/blob/main/assets/images/authorization-success.png" alt="Autorización exitosa de usuario">

- <h4>Registro de otro usuario</h4>
Tambien se puede registrar un usuario nuevo en el sistema, que por defecto tendrá el role `user`, como se muestra en la imagen

<img src="https://github.com/juanm-mrqz/forohub_challenge/blob/main/assets/images/signup-request.png" alt="Solicitud de registro de un usuario">
<img src="https://github.com/juanm-mrqz/forohub_challenge/blob/main/assets/images/signup-response.png" alt="Respuesta al registro de un usuario">


<h2>TODO</h2>
Si bien la funcionalidad mínima requerida esta cumplida, todavía quedan algunas funcionalidades que se podria agregar a la app, como 
- Modificar los permisos de las url segun el privilegio del usuario. 
- Crear controllers especificos para el manejo de Cursos y Respuestas. 


- <h4>Registrar topicos</h4>
La funcionalidad principal de registrar topicos, requiere de un usuario autenticado (ya sea el admin por defecto, o un nuevo usuario registrado) 

<img src="https://github.com/juanm-mrqz/forohub_challenge/blob/main/assets/images/post-topic_request.png" alt="Solicitud para crear topicos">
<img src="https://github.com/juanm-mrqz/forohub_challenge/blob/main/assets/images/post-topic_response.png" alt="Respuesta de registro de topicos">

