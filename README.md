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
- `IntelliJ IDEA`

<h2>Modelado del proyecto</h2>
<img src="https://github.com/juanm-mrqz/forohub_challenge/blob/main/assets/images/db-schema.png" alt="Esquema de base de datos">

- <h4>Inicializacion de Base de datos</h2>
Antes de probar la app, hay que configurar el archivo `application properties` para poder utilizar en el entorno local de MySQL con una base
de datos propia. Se deben reemplazar los campos:<br/>
    - `spring.datasource.url=jdbc:mysql://localhost:3306/<nombre_db>`
    - `spring.datasource.username=<usuario>`
    - `spring.datasource.password=<contraseña>`

- <h4>Inicializacion de datos</h4>
