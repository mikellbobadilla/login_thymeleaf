# SpringBoot3 Login con Thymeleaf

Este es un ejemplo de Configuración básica de **Spring Security 6** con **SpringBoot 3** más un motor de plantilla **Thymeleaf**.

Spring Security tiene su propia página de login, yo uso una personalizada por preferencias.

**Importante:**

Para Entender como funciona este proyecto, puedes ir a este repositorio, donde está explicado 
en detalle el proyecto, después te recomiendo examinar este proyecto.

[Link del Repositorio.](https://github.com/mikellbobadilla/login-mvc)

## Empezando

**Docker**\
Clona el proyecto.

```shell
git clone https://github.com/mikellbobadilla/login_thymeleaf.git
cd login_thymeleaf
```

```shell
# Si estas en Linux es necesario ejecutarlo con sudo 
docker-compose up
```

**Sin Docker**\
Si en tu PC no tienes instalado Docker, puedes iniciarlo de forma manual.

**Requisitos Antes de iniciarlo:**

- [JDK 17 o superior.](https://learn.microsoft.com/en-us/java/openjdk/download)
- [maven](https://maven.apache.org/download.cgi)
- [MYSQL o MariaDB.](https://dev.mysql.com/downloads/mysql/)

En el archivo **\src\main\resources\application.properties** debes modificarlo con la contraseña y usuario de tu gestor de base de datos. Y también deber crear la base de datos llamada **login**.

```properties
spring.jpa.hibernate.ddl-auto=create-drop
# spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/login
spring.datasource.username=tu Usuario
spring.datasource.password=tu contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

Cuando la base de datos esté iniciada ya poder ejecutar la aplicación.

```shell
mvn spring-boot:run # Para ejecutarlo en modo desarrollador
```

Si quieres compilarlo ejecuta estos comandos:

```shell
mvn clean # Para limpiar
mvn install # Para compilar
```

Si al final tira un mensaje **Build Success** nos indicará que ya está compilado.

El proyecto compilado se encontrará en la carpeta **target**, lo encontraremos como un archivo **.jar**.

Para ejecutar el archivo **jar** ejecutamos:

```shell
java -jar ./target/login_thymeleaf-1.0.0.jar
```

Listo ya estaría ir al navegador e ir a http://localhost:8080.
